package com.uniubi.cloud.athena.sdk.common.http.defaults;

import com.uniubi.cloud.athena.sdk.common.exception.AthenaHttpException;
import com.uniubi.cloud.athena.sdk.common.http.ClientConfig;
import com.uniubi.cloud.athena.sdk.common.http.RequestConverter;
import com.uniubi.cloud.athena.sdk.common.http.ResponseConverter;
import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Map;

import static com.uniubi.cloud.athena.sdk.common.constant.DeveloperConstants.HTTP_OK_CODE;
import static com.uniubi.cloud.athena.sdk.common.constant.DeveloperConstants.SDK_UNIFY_CONTENT_TYPE;

/**
 * 宇泛httpClient的默认实现 用来发送http请求 约定： 1.sdk请求统一使用 POST 方法 2.请求ContentType统一使用
 * application/json 请求使用OkHttp实现发送http请求 请求发送前会将请求体交给 requestConverter 做请求体序列化过程 请求响应结果会交给
 * responseConverter 进行响应结果的反序列化过程处理 通过 clientConfig 可以对请求进行超时配置
 *
 * @author jingmu
 * @since 2020/3/26
 * @see RequestConverter 请求体转换器，用于将请求体序列化为字符串
 * @see ResponseConverter 响应体转换器，用于将服务端返回的字符串转为响应对象
 * @see ClientConfig 请求配置，用于设置请求的一些超时参数
 */
public class DefaultUniUbiHttpClient implements UniUbiHttpClient {

    private final RequestConverter requestConverter;

    private final ResponseConverter responseConverter;

    private final ClientConfig clientConfig;

    private OkHttpClient client;

    public DefaultUniUbiHttpClient(RequestConverter requestConverter, ResponseConverter responseConverter,
            ClientConfig clientConfig) {
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
        this.clientConfig = clientConfig;
        initClient();
    }

    private void initClient() {
        this.client = OkHttpClientHolder.getInstance(clientConfig);
    }

    @Override
    public <T> T sendPostRequest(String url, Object requestBody, Map<String, String> headers, Type responseType)
            throws Exception {
        // 1.获取请求
        Request request = buildRequest(url, requestBody, headers);
        // 2.发送请求
        Response response;
        try {
            response = client.newCall(request).execute();
        }
        catch (ConnectException ce) {
            // 请求失败,失败原因: 404
            throw new AthenaHttpException(HttpErrorCodeEnum.CODE_404.getDesc());
        }
        catch (SocketTimeoutException se) {
            // 请求失败,失败原因: 408
            throw new AthenaHttpException(HttpErrorCodeEnum.CODE_408.getDesc());
        }
        // 3. 响应处理
        if (response.code() == HTTP_OK_CODE) {
            // 4. 获取响应结果
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String responseContent = body.string();
            return responseConverter.converter(responseContent, responseType);
        }
        else {
            HttpErrorCodeEnum httpErrorCodeEnum = HttpErrorCodeEnum.getByCode(response.code());
            throw new AthenaHttpException(httpErrorCodeEnum.getDesc());
        }
    }

    private Request buildRequest(String url, Object requestBody, Map<String, String> headers) {
        // 创建请求header
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers != null) {
            headers.forEach(headerBuilder::add);
        }
        Headers header = headerBuilder.build();
        // 创建请求参数内容
        String bodyContent = requestConverter.converter(requestBody);
        RequestBody body = RequestBody.create(SDK_UNIFY_CONTENT_TYPE, bodyContent);
        // 创建请求对象
        return new Request.Builder().url(url).post(body).headers(header).build();
    }

}
