package com.uniubi.cloud.athena.sdk.clients;

import com.uniubi.cloud.athena.sdk.common.annotation.RequestMark;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;
import com.uniubi.cloud.athena.sdk.common.models.request.VisitorAddRequest;
import com.uniubi.cloud.athena.sdk.common.models.request.VisitorFaceAddRequest;
import com.uniubi.cloud.athena.sdk.common.models.request.VisitorFaceDeleteRequest;
import com.uniubi.cloud.athena.sdk.common.models.request.VisitorQueryRequest;
import com.uniubi.cloud.athena.sdk.common.models.response.VisitorDetailResponse;

/**
 * 访客相关API
 * @author feima
 * @since 2023-08-21
 */
public interface SdkVisitorApi {

    /**
     * 添加访客信息
     * <p>
     * add visitor
     * @param request 请求参数
     */
    @RequestMark(name = "addVisitor", version = "v2", desc = "添加访客信息")
    SdkResult<Void> addVisitor(VisitorAddRequest request);

    /**
     * 添加访客照片
     * <p>
     * add visitor face photo
     * @param request 请求参数
     */
    @RequestMark(name = "addVisitorFace", version = "v2", desc = "添加访客照片")
    SdkResult<Void> addVisitorFace(VisitorFaceAddRequest request);

    /**
     * 查询访客信息
     * <p>
     * query visitor info
     * @param request 请求参数
     * @return visitorDetailResponse
     */
    @RequestMark(name = "queryVisitorInfo", version = "v2", desc = "查询访客信息")
    SdkResult<VisitorDetailResponse> queryVisitorInfo(VisitorQueryRequest request);

    /**
     * 访客信息编辑修改
     * <p>
     * edit visitor info
     * @param request 请求参数
     */
    @RequestMark(name = "editVisitor", version = "v2", desc = "访客信息编辑修改")
    SdkResult<Void> editVisitor(VisitorQueryRequest request);

    /**
     * 删除访客
     * <p>
     * delete visitor
     * @param request 请求参数
     */
    @RequestMark(name = "deleteVisitor", version = "v2", desc = "删除访客")
    SdkResult<Void> deleteVisitor(VisitorQueryRequest request);

    /**
     * 删除访客照片
     * <p>
     * delete visitor face photo
     * @param request 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "deleteVisitorFace", version = "v2", desc = "删除访客照片")
    SdkResult<Void> deleteVisitorFace(VisitorFaceDeleteRequest request);

}
