package com.uniubi.cloud.athena.sdk.api.simple.example;

import com.uniubi.cloud.athena.sdk.clients.AthenaSdkApiClient;
import com.uniubi.cloud.athena.sdk.clients.SdkAtdReportApi;
import com.uniubi.cloud.athena.sdk.common.models.SdkPageInfo;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;
import com.uniubi.cloud.athena.sdk.common.models.request.AtdReportQueryRequest;
import com.uniubi.cloud.athena.sdk.common.models.response.AtdDetailReportResponseModel;

/**
 * @author 井木
 * @since 2022/12/14
 */
public class SdkAtdReportApiExample extends SdkBaseContext{

    public static void main(String[] args) {
        SdkAtdReportApi sdkApi = getSdkApi();
        AtdReportQueryRequest request = new AtdReportQueryRequest();
        request.setPageNum(1);
        request.setPageSize(10);
        SdkResult<SdkPageInfo<AtdDetailReportResponseModel>> result = sdkApi.atdDetailReport(request);
        System.out.println(result);

    }

    private static SdkAtdReportApi getSdkApi() {
        // 5. create the AthenaSdkApiClient
        AthenaSdkApiClient athenaSdkApiClient = athenaSdkApiClient();
        // 6. get api instance
        return athenaSdkApiClient.createSdkAtdReportApi();
    }
}
