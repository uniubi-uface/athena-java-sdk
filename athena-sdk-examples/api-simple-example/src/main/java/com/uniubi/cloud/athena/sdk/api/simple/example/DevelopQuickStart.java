package com.uniubi.cloud.athena.sdk.api.simple.example;

import com.uniubi.cloud.athena.sdk.clients.AthenaSdkApiClient;
import com.uniubi.cloud.athena.sdk.clients.SdkTestApi;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;

/**
 * quick start
 * @author jingmu
 * @since 2022/02/24
 */
public class DevelopQuickStart extends SdkBaseContext {

    public static void main(String[] args) {
        SdkTestApi sdkTestApi = getSdkApi();
        // 7. RPC call UStar API
        SdkResult<String> result = sdkTestApi.test("api-simple-example");
        // 8. print the result
        System.out.println(result);
    }

    private static SdkTestApi getSdkApi() {
        AthenaSdkApiClient athenaSdkApiClient = athenaSdkApiClient();
        // 6. get api instance
        return athenaSdkApiClient.createSdkTestApi();
    }

}
