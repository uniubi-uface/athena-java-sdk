package com.uniubi.cloud.athena.sdk.common.http;

import com.uniubi.cloud.athena.sdk.common.http.defaults.DefaultResponseConverter;

import java.lang.reflect.Type;

/**
 * 响应转换器 UniUbiHttpClient 使用该类对请求结果进行反序列化操作
 *
 * @author jingmu
 * @date 2020/3/26
 * @see UniUbiHttpClient 宇泛httpClient，用于发送sdk请求到服务端的http实现
 * @see DefaultResponseConverter
 */
public interface ResponseConverter {

    /**
     * 对象转换
     * @param responseContent 响应内容
     * @param classType 需要转换的类型
     * @return 返回结果
     */
    <T> T converter(String responseContent, Type classType);

}
