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
 * @since 2020/5/18
 */
public interface SdkDeviceRecognitionApi {

    /**
     * 分页查询设备识别记录
     * <p>
     * Paging query device identification record
     * @param queryRecognitionPageRequest query params
     * @return <code>SdkResult<SdkPageInfo<RecognitionResponseModel>></code>
     */
    @RequestMark(name = "queryRecognitionPage", version = "v1", desc = "分页查询识别记录")
    SdkResult<SdkPageInfo<RecognitionResponseModel>> queryRecognitionPage(
            RecognitionPageQueryRequest queryRecognitionPageRequest);

}
