package com.uniubi.cloud.athena.sdk.common.http.defaults;

import com.alibaba.fastjson.JSONObject;
import com.uniubi.cloud.athena.sdk.common.http.ResponseConverter;

import java.lang.reflect.Type;

/**
 * 默认响应结果转换器 使用fastJson对响应结果字符串转为结果类型
 *
 * @author jingmu
 * @since 2020/3/26
 */
public class DefaultResponseConverter implements ResponseConverter {

    @Override
    public <T> T converter(String responseContent, Type classType) {
        if (classType == null) {
            return null;
        }
        if (responseContent == null || responseContent.isEmpty()) {
            return null;
        }
        return JSONObject.parseObject(responseContent, classType);
    }

}
