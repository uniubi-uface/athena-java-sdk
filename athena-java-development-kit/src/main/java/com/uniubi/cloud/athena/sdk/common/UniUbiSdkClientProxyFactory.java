package com.uniubi.cloud.athena.sdk.common;

import com.uniubi.cloud.athena.sdk.auth.SimpleTokenLoader;
import com.uniubi.cloud.athena.sdk.common.annotation.RequestMark;
import com.uniubi.cloud.athena.sdk.common.annotation.RequestParam;
import com.uniubi.cloud.athena.sdk.common.constant.DeveloperConstants;
import com.uniubi.cloud.athena.sdk.common.http.ClientConfig;
import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;
import com.uniubi.cloud.athena.sdk.common.http.defaults.DefaultRequestConverter;
import com.uniubi.cloud.athena.sdk.common.http.defaults.DefaultUniUbiHttpClient;
import com.uniubi.cloud.athena.sdk.common.utils.AthenaSdkEncrypt;
import com.uniubi.cloud.athena.sdk.decrypt.DecryptResponseConverter;
import com.uniubi.cloud.athena.sdk.interceptors.RpcMethodReAuthInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * sdk客户端代理工厂 用来创建接口的动态代理对象 该类的createProxy()方法会将传入的接口进行处理： 把该接口标注有RequestMark注解的方法代理处理
 *
 * @author jingmu
 * @since 2020/3/26
 * @see RequestMark 请求方法标注
 * @see RequestParam 请求方法简单参数标注
 */
public class UniUbiSdkClientProxyFactory {

    private final ClientProxyConfig clientProxyConfig;

    public UniUbiSdkClientProxyFactory(String accessKey, String accessSecret, RequestConfig requestConfig) {

        clientProxyConfig = createClientProxyConfig(accessKey, accessSecret, requestConfig);
    }

    private ClientProxyConfig createClientProxyConfig(String accessKey, String accessSecret,
            RequestConfig requestConfig) {
        ClientProxyConfig clientProxyConfig = new ClientProxyConfig();
        // 解析requestUrl
        clientProxyConfig.requestUrl = requestConfig.getEndPoint() + DeveloperConstants.ATHENA_SDK_UNIFY_URL;
        // 获取客户端配置
        ClientConfig clientConfig = getClientConfig(requestConfig);
        // 创建http请求client
        clientProxyConfig.defaultRequestConverter = new DefaultRequestConverter();
        clientProxyConfig.uniUbiHttpClient = new DefaultUniUbiHttpClient(clientProxyConfig.defaultRequestConverter,
                new DecryptResponseConverter(requestConfig.getPublicKey()), clientConfig);
        // 获取语言
        if (requestConfig.getSdkLang() == null) {
            clientProxyConfig.sdkLang = SdkLang.CN;
        }
        else {
            clientProxyConfig.sdkLang = requestConfig.getSdkLang();
        }
        // 获取tokenLoader
        if (requestConfig.getTokenLoader() != null) {
            clientProxyConfig.tokenLoader = requestConfig.getTokenLoader();
        }
        else {
            clientProxyConfig.tokenLoader = new SimpleTokenLoader(clientProxyConfig.uniUbiHttpClient,
                    clientProxyConfig.requestUrl, accessKey, accessSecret, clientProxyConfig.sdkLang);
        }
        // 获取方法拦截器
        if (requestConfig.getRpcMethodInterceptor() != null) {
            clientProxyConfig.rpcMethodInterceptor = requestConfig.getRpcMethodInterceptor();
        }
        else {
            clientProxyConfig.rpcMethodInterceptor = new RpcMethodReAuthInterceptor();
        }
        clientProxyConfig.publicKey = requestConfig.getPublicKey();
        return clientProxyConfig;
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxy(Class<T> sdkClientType) {
        ClientProxy clientProxy = new ClientProxy(clientProxyConfig);
        return (T) Proxy.newProxyInstance(UniUbiSdkClientProxyFactory.class.getClassLoader(),
                new Class[] { sdkClientType }, clientProxy);
    }

    private ClientConfig getClientConfig(RequestConfig requestConfig) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setConnectionTimeoutMills(requestConfig.getConnectionTimeoutMills());
        clientConfig.setReadTimeoutMills(requestConfig.getReadTimeoutMills());
        clientConfig.setWriteTimeoutMills(requestConfig.getWriteTimeoutMills());
        return clientConfig;
    }

    /**
     * sdkClient代理对象
     */
    private static class ClientProxy implements InvocationHandler {

        private final TokenLoader tokenLoader;

        private final UniUbiHttpClient uniUbiHttpClient;

        private final String requestUrl;

        private final RpcMethodInterceptor rpcMethodInterceptor;

        private final SdkLang sdkLang;

        private final String publicKey;

        private final DefaultRequestConverter defaultRequestConverter;

        private ClientProxy(ClientProxyConfig clientProxyConfig) {
            this.tokenLoader = clientProxyConfig.tokenLoader;
            this.uniUbiHttpClient = clientProxyConfig.uniUbiHttpClient;
            this.requestUrl = clientProxyConfig.requestUrl;
            this.rpcMethodInterceptor = clientProxyConfig.rpcMethodInterceptor;
            this.sdkLang = clientProxyConfig.sdkLang;
            this.publicKey = clientProxyConfig.publicKey;
            this.defaultRequestConverter = clientProxyConfig.defaultRequestConverter;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 获取方法上的RequestMark标注，获取请求key
            RequestMark requestMark = method.getAnnotation(RequestMark.class);
            if (requestMark == null) {
                return method.invoke(proxy, args);
            }
            String requestKey = requestMark.name();
            String version = requestMark.version();
            String aesKey = AthenaSdkEncrypt.generateAesKey();
            assert aesKey != null;
            String secretKey = AthenaSdkEncrypt.encrypt(aesKey, publicKey);
            // 获取请求header，将token和请求key都放进header中
            Map<String, String> headers = getHeader(requestKey, version, secretKey);
            // 获取请求参数
            Object requestBody = getRequestBody(args, method);
            String requestContent = defaultRequestConverter.converter(requestBody);
            String secretContent = AthenaSdkEncrypt.encryptByAes(aesKey, requestContent);
            // 获取该方法的返回值
            Type genericReturnType = method.getGenericReturnType();
            // @formatter:off
            // 封装rpc方法
            RpcMethod rpcMethod = new RpcMethod();
            rpcMethod.setArgs(args);
            rpcMethod.setMethod(method);
            rpcMethod.setHeaders(headers);
            rpcMethod.setRequestBody(secretContent);
            rpcMethod.setRequestUrl(requestUrl);
            rpcMethod.setReturnType(genericReturnType);
            rpcMethod.setTokenLoader(tokenLoader);
            rpcMethod.setUniUbiHttpClient(uniUbiHttpClient);
            // 发送请求，并响应结果
            return rpcMethodInterceptor.process(rpcMethod);
            // @formatter:on
        }

        /**
         * 根据方法参数获取请求体对象
         * @param args 方法参数
         * @param method 方法
         * @return 返回最后的请求体对象
         */
        private Object getRequestBody(Object[] args, Method method) {
            Object requestBody;
            if (args != null && args.length != 0) {
                Parameter[] parameters = method.getParameters();
                // 只取第一个参数
                requestBody = args[0];
                RequestParam requestParam = parameters[0].getAnnotation(RequestParam.class);
                if (requestParam != null) {
                    requestBody = Collections.singletonMap(requestParam.value(), args[0]);
                }
            }
            else {
                requestBody = null;
            }
            return requestBody;
        }

        /**
         * 获取请求头
         * @param requestKey 请求key
         * @param version 请求key version
         * @param secretKey 密钥
         * @return 返回构建后的请求头
         */
        private Map<String, String> getHeader(String requestKey, String version, String secretKey) {
            Map<String, String> headers = new HashMap<>(2);
            String token = tokenLoader.loadToken();
            headers.put(DeveloperConstants.HEADER_REQUEST_KEY_NAME, requestKey);
            headers.put(DeveloperConstants.HEADER_REQUEST_KEY_VERSION, version);
            headers.put(DeveloperConstants.HEADER_ACCESS_TOKEN_NAME, token);
            headers.put(DeveloperConstants.HEADER_LANG_NAME, sdkLang.getValue());
            headers.put(DeveloperConstants.HEADER_SECRET_KEY_NAME, secretKey);
            return headers;
        }

    }

    /**
     * @author admin
     */
    private static class ClientProxyConfig {

        private TokenLoader tokenLoader;

        private UniUbiHttpClient uniUbiHttpClient;

        private String requestUrl;

        private RpcMethodInterceptor rpcMethodInterceptor;

        private SdkLang sdkLang;

        private String publicKey;

        private DefaultRequestConverter defaultRequestConverter;

    }

}
