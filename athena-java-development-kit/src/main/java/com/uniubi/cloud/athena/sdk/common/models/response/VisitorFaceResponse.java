package com.uniubi.cloud.athena.sdk.common.models.response;

/**
 * @author FeiMa
 */
public class VisitorFaceResponse {

    /**
     * 来访人注册照id
     */
    private Long visitorFaceId;

    /**
     * 来访人人脸照片URL
     */
    private String faceUrl;

    /**
     * 访客卡号
     */
    private String cardNo;

    public Long getVisitorFaceId() {
        return visitorFaceId;
    }

    public void setVisitorFaceId(Long visitorFaceId) {
        this.visitorFaceId = visitorFaceId;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
