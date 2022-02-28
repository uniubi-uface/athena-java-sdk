package com.uniubi.cloud.athena.sdk.api.simple.example;

import com.uniubi.cloud.athena.sdk.clients.AthenaSdkApiClient;
import com.uniubi.cloud.athena.sdk.clients.SdkTestApi;
import com.uniubi.cloud.athena.sdk.common.RequestConfig;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;

/**
 * quick start
 *
 * @author jingmu
 * @since 2022/02/24
 */
public class DevelopQuickStart {

    static final String PUBLIC_KEY = "input your public key.";

    static final String ACCESS_KEY = "input your access key.";

    static final String ACCESS_SECRET = "input your access key.";

    public static void main(String[] args) {
        // 1. new RequestConfig
        RequestConfig requestConfig = new RequestConfig();
        // 2. set connection time out
        requestConfig.setConnectionTimeoutMills(3000L);
        requestConfig.setReadTimeoutMills(3000L);
        // 3. set your public key
        requestConfig.setPublicKey(PUBLIC_KEY);
        // 4. set service end point if necessary
        requestConfig.setEndPoint("https://www.ustar-cloud.com/api");
        // 5. create the AthenaSdkApiClient
        AthenaSdkApiClient athenaSdkApiClient = new AthenaSdkApiClient(ACCESS_KEY, ACCESS_SECRET, requestConfig);
        // 6. get api instance
        SdkTestApi sdkTestApi = athenaSdkApiClient.createSdkTestApi();
        // 7. RPC call UStar Cloud API
        SdkResult<String> result = sdkTestApi.test();
        // 8. print the result
        System.out.println(result);
    }

}
