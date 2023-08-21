package com.uniubi.cloud.athena.sdk.common.models.request;

/**
 * 访客照片删除请求实体类
 * @author FeiMa
 */
public class VisitorFaceDeleteRequest extends VisitorQueryRequest {

    /**
     * 访客照片id
     */
    private Long visitorFaceId;

    public Long getVisitorFaceId() {
        return visitorFaceId;
    }

    public void setVisitorFaceId(Long visitorFaceId) {
        this.visitorFaceId = visitorFaceId;
    }
}
