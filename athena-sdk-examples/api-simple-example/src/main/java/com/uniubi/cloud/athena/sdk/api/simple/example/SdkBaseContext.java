package com.uniubi.cloud.athena.sdk.api.simple.example;

import com.uniubi.cloud.athena.sdk.clients.AthenaSdkApiClient;
import com.uniubi.cloud.athena.sdk.common.RequestConfig;

/**
 * @author 井木
 * @since 2022/12/09
 */
public class SdkBaseContext {

    static final String PUBLIC_KEY = "";

    static final String ACCESS_KEY = "fff4b1d9f7054bd8bab523b43004ad3b";

    static final String ACCESS_SECRET = "fa9283ce171145be817d6f8b99ff3b37";

    protected static RequestConfig getRequestConfig() {
        // 1. new RequestConfig
        RequestConfig requestConfig = new RequestConfig();
        // 2. set connection time out
        requestConfig.setConnectionTimeoutMills(3000L);
        requestConfig.setReadTimeoutMills(3000L);
        // 3. set your public key
        requestConfig.setPublicKey(PUBLIC_KEY);
        // 4. set service end point if necessary
        requestConfig.setEndPoint("http://127.0.0.1:8080");
        return requestConfig;
    }

    protected static AthenaSdkApiClient athenaSdkApiClient() {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.header", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.defaultlog", "debug");
        // 5. create the AthenaSdkApiClient
        return new AthenaSdkApiClient(ACCESS_KEY, ACCESS_SECRET, getRequestConfig());
    }

}
