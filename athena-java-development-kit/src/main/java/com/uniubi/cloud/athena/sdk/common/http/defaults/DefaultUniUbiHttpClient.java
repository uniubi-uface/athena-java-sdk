package com.uniubi.cloud.athena.sdk.common.http.defaults;

import com.alibaba.fastjson.JSON;
import com.uniubi.cloud.athena.sdk.common.exception.AthenaHttpException;
import com.uniubi.cloud.athena.sdk.common.http.ClientConfig;
import com.uniubi.cloud.athena.sdk.common.http.RequestConverter;
import com.uniubi.cloud.athena.sdk.common.http.ResponseConverter;
import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.uniubi.cloud.athena.sdk.common.constant.DeveloperConstants.HTTP_OK_CODE;

/**
 * <pre>
 * 宇泛httpClient的默认实现 用来发送http请求 约定：
 *      1.sdk请求统一使用 POST 方法
 *      2.请求ContentType统一使用 application/json
 * </pre>
 * @author jingmu
 * @see RequestConverter 请求体转换器，用于将请求体序列化为字符串
 * @see ResponseConverter 响应体转换器，用于将服务端返回的字符串转为响应对象
 * @see ClientConfig 请求配置，用于设置请求的一些超时参数
 * @since 2020/3/26
 */
public class DefaultUniUbiHttpClient implements UniUbiHttpClient {

    public DefaultUniUbiHttpClient(ClientConfig clientConfig) {
        initClient(clientConfig);
    }

    private void initClient(ClientConfig clientConfig) {
        HttpClientHolder.init(clientConfig);
    }

    @Override
    public <T> T sendPostRequest(String url, Object requestBody, Map<String, String> headers, Type responseType)
        throws Exception {
        // 1.获取请求
        HttpPost httpPost = buildRequest(url, requestBody, headers);
        // 2.发送请求
        HttpResponse response;
        try {
            HttpClient httpClient = HttpClientHolder.getHttpClient();
            response = httpClient.execute(httpPost);
        } catch (ConnectException ce) {
            // 请求失败,失败原因: 404
            throw new AthenaHttpException(HttpErrorCodeEnum.CODE_404.getDesc());
        } catch (SocketTimeoutException se) {
            // 请求失败,失败原因: 408
            throw new AthenaHttpException(HttpErrorCodeEnum.CODE_408.getDesc());
        }
        // 3. 响应处理
        if (response.getStatusLine().getStatusCode() == HTTP_OK_CODE) {
            // 4. 获取响应结果
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity == null) {
                return null;
            }
            String responseContent = EntityUtils.toString(responseEntity);
            return JSON.parseObject(responseContent, responseType);
        } else {
            HttpErrorCodeEnum httpErrorCodeEnum = HttpErrorCodeEnum.getByCode(response.getStatusLine().getStatusCode());
            throw new AthenaHttpException(httpErrorCodeEnum.getDesc());
        }
    }

    private HttpPost buildRequest(String url, Object requestBody, Map<String, String> headers) {
        // 创建请求对象
        HttpPost httpPost = new HttpPost(url);
        // 创建请求header
        if (headers != null) {
            headers.forEach(httpPost::addHeader);
        }
        // 创建请求参数内容
        httpPost.setEntity(new StringEntity(JSON.toJSONString(requestBody), StandardCharsets.UTF_8));
        return httpPost;
    }

}
