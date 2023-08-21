package com.uniubi.cloud.athena.sdk.common.models.response;

/**
 * @author xiying
 */
public class EmpFaceVO extends EmpBaseVO {

    /**
     * 员工注册照id
     */
    private Long empFaceId;

    /**
     * 员工注册照Url
     */
    private String empFaceUrl;

    /**
     * 员工卡号
     */
    private String cardNo;


    public Long getEmpFaceId() {
        return empFaceId;
    }

    public void setEmpFaceId(Long empFaceId) {
        this.empFaceId = empFaceId;
    }

    public String getEmpFaceUrl() {
        return empFaceUrl;
    }

    public void setEmpFaceUrl(String empFaceUrl) {
        this.empFaceUrl = empFaceUrl;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
