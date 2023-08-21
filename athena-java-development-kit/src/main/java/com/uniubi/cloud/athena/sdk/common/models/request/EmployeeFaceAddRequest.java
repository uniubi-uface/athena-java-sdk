package com.uniubi.cloud.athena.sdk.common.models.request;

/**
 * 员工人脸照添加请求
 * @author FeiMa
 */
public class EmployeeFaceAddRequest {


    /**
     * 员工编号
     */
    private String empNo;

    /**
     * 企业id
     */
    private Long orgId;

    /**
     * 用户照片
     */
    private String photoBase64;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }
}
