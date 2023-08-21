package com.uniubi.cloud.athena.sdk.common.models.request;

/**
 * 访客人脸照添加请求
 * @author FeiMa
 */
public class VisitorFaceAddRequest {


    /**
     * 访客id
     */
    private Long recordId;

    /**
     * 企业id
     */
    private Long orgId;

    /**
     * 用户照片
     */
    private String photoBase64;

}
