package com.uniubi.cloud.athena.sdk.api.simple.example;


import com.uniubi.cloud.athena.sdk.clients.AthenaSdkApiClient;
import com.uniubi.cloud.athena.sdk.common.RequestConfig;

/**
 * @author 井木
 * @since 2022/12/09
 */
public class SdkBaseContext {

    static final String PUBLIC_KEY = "1";

    static final String ACCESS_KEY = "1";

    static final String ACCESS_SECRET = "1";

    protected static RequestConfig getRequestConfig() {
        // 1. new RequestConfig
        RequestConfig requestConfig = new RequestConfig();
        // 2. set connection time out
        requestConfig.setConnectionTimeoutMills(3000L);
        requestConfig.setReadTimeoutMills(3000L);
        // 3. set your public key
        requestConfig.setPublicKey(PUBLIC_KEY);
        // 4. set service end point if necessary
        requestConfig.setEndPoint("https://www.ustar-cloud.com/api");
        return requestConfig;
    }

    protected static AthenaSdkApiClient athenaSdkApiClient() {
        // 5. create the AthenaSdkApiClient
        return new AthenaSdkApiClient(ACCESS_KEY, ACCESS_SECRET, getRequestConfig());
    }
}
