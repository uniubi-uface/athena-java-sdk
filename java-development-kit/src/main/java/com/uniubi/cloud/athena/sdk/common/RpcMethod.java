package com.uniubi.cloud.athena.sdk.common;

import com.uniubi.cloud.athena.sdk.common.exception.UniUbiAresSDKException;
import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;
import lombok.Data;
import lombok.experimental.Accessors;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * com.uniubi.medusa.ares.develop.api.common.RpcMethod
 *
 * @author jingmu
 * @date 2020/5/7
 */
@Data
@Accessors(chain = true)
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

}
