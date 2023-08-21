package com.uniubi.cloud.athena.sdk.common.models.response;

/**
 * 公司职业类型表
 */
public class EmployeeTypeVO {

    /**
     * 员工职业类型ID
     */
    private Long empTypeId;

    /**
     * 员工职业类型名称
     */
    private String empTypeName;

    public Long getEmpTypeId() {
        return empTypeId;
    }

    public void setEmpTypeId(Long empTypeId) {
        this.empTypeId = empTypeId;
    }

    public String getEmpTypeName() {
        return empTypeName;
    }

    public void setEmpTypeName(String empTypeName) {
        this.empTypeName = empTypeName;
    }
}