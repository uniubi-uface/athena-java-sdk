package com.uniubi.cloud.athena.sdk.common.http;

import com.uniubi.cloud.athena.sdk.common.http.defaults.DefaultRequestConverter;

/**
 * 请求转换器 UniUbiHttpClient 使用该类对请求体进行序列化操作
 * @author jingmu
 * @see UniUbiHttpClient 宇泛httpClient，用于发送sdk请求到服务端的http实现
 * @see DefaultRequestConverter
 * @since 2020/3/26
 */
public interface RequestConverter {

    /**
     * 对象转换
     * @param requestBody 请求body
     * @return 返回转换的字符串
     */
    String converter(Object requestBody);

}
