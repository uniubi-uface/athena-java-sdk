package com.uniubi.cloud.athena.sdk.common.http.defaults;

import com.alibaba.fastjson.JSONObject;
import com.uniubi.cloud.athena.sdk.common.http.RequestConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认请求转换器 使用fastJson直接将对象转为字符串
 *
 * @author jingmu
 * @date 2020/3/26
 */
public class DefaultRequestConverter implements RequestConverter {

    /**
     * 空请求体常量
     */
    public static final Map<String, String> EMPTY_PARAM;

    /**
     * 统一请求参数名称
     */
    public static final String REQUEST_DATA_KEY;

    static {
        REQUEST_DATA_KEY = "requestData";
        EMPTY_PARAM = new HashMap<>(1);
        EMPTY_PARAM.put(REQUEST_DATA_KEY, "{}");
    }

    @Override
    public String converter(Object requestBody) {
        if (requestBody == null) {
            // 如果请求体为空，返回固定空请求体
            requestBody = EMPTY_PARAM;
        }
        else {
            if (requestBody instanceof String) {
                return (String) requestBody;
            }
            // 如果不为空，则封装请求体
            Map<String, Object> unifyParam = new HashMap<>(1);
            String requestContent = JSONObject.toJSONString(requestBody);
            unifyParam.put(REQUEST_DATA_KEY, requestContent);
            requestBody = unifyParam;
        }
        return JSONObject.toJSONString(requestBody);
    }

}
