package com.uniubi.cloud.athena.sdk.common.http;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * 宇泛httpClient 用来发送http请求
 *
 * @author jingmu
 * @date 2020/3/26
 * @see RequestConverter 请求体转换器，用于将请求体序列化为字符串
 * @see ResponseConverter 响应体转换器，用于将服务端返回的字符串转为响应对象
 * @see ClientConfig 请求配置，用于设置请求的一些超时参数
 */
public interface UniUbiHttpClient {

    /**
     * 发送请求
     * @param url 请求路径
     * @param requestBody 请求体
     * @param headers 请求头部
     * @param responseType 结果返回类型
     * @param <T> 返回结果类型
     * @return 返回请求结果
     */
    <T> T sendPostRequest(String url, Object requestBody, Map<String, String> headers, Type responseType)
            throws Exception;

}
