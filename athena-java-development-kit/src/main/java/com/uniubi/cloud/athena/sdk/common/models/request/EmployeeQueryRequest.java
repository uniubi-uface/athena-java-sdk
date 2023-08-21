package com.uniubi.cloud.athena.sdk.common.models.request;

/**
 * 员工信息查询请求实体类
 * @author FeiMa
 */
public class EmployeeQueryRequest {

    /**
     * 员工编号
     */
    private String empNo;
    /**
     * 企业信息
     */
    private Long orgId;

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
}
