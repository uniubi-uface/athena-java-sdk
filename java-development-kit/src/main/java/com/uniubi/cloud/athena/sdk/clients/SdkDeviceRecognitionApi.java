package com.uniubi.cloud.athena.sdk.clients;

import com.uniubi.cloud.athena.sdk.common.annotation.RequestMark;
import com.uniubi.cloud.athena.sdk.common.models.SdkPageInfo;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;
import com.uniubi.cloud.athena.sdk.common.models.request.RecognitionPageQueryRequest;
import com.uniubi.cloud.athena.sdk.common.models.response.RecognitionResponseModel;

/**
 * com.uniubi.medusa.ares.develop.api.clients.SdkDeviceRecognitionApi
 *
 * @author jingmu
 * @date 2020/5/18
 */
public interface SdkDeviceRecognitionApi {

    @RequestMark(name = "queryRecognitionPage", version = "v1", desc = "分页查询识别记录")
    SdkResult<SdkPageInfo<RecognitionResponseModel>> queryRecognitionPage(
            RecognitionPageQueryRequest queryRecognitionPageRequest);

}
