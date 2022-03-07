package com.uniubi.cloud.athena.sdk.common;

import com.uniubi.cloud.athena.sdk.common.exception.UniUbiAresSDKException;
import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

/**
 * com.uniubi.medusa.ares.develop.api.common.RpcMethod
 *
 * @author jingmu
 * @since 2020/5/7
 */
public class RpcMethod {

    private UniUbiHttpClient uniUbiHttpClient;

    private String requestUrl;

    private Object requestBody;

    private Map<String, String> headers;

    private Type returnType;

    private Method method;

    private Object[] args;

    private TokenLoader tokenLoader;

    public Object invoke() {
        try {
            return uniUbiHttpClient.sendPostRequest(requestUrl, requestBody, headers, returnType);
        }
        catch (Exception e) {
            throw new UniUbiAresSDKException(e);
        }
    }

    public UniUbiHttpClient getUniUbiHttpClient() {
        return uniUbiHttpClient;
    }

    public void setUniUbiHttpClient(UniUbiHttpClient uniUbiHttpClient) {
        this.uniUbiHttpClient = uniUbiHttpClient;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Object getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(Object requestBody) {
        this.requestBody = requestBody;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public TokenLoader getTokenLoader() {
        return tokenLoader;
    }

    public void setTokenLoader(TokenLoader tokenLoader) {
        this.tokenLoader = tokenLoader;
    }

    @Override
    public String toString() {
        return "RpcMethod{" + "uniUbiHttpClient=" + uniUbiHttpClient + ", requestUrl='" + requestUrl + '\''
                + ", requestBody=" + requestBody + ", headers=" + headers + ", returnType=" + returnType + ", method="
                + method + ", args=" + Arrays.toString(args) + ", tokenLoader=" + tokenLoader + '}';
    }

}
