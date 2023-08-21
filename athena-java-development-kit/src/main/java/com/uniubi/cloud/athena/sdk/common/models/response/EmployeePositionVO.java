package com.uniubi.cloud.athena.sdk.common.models.response;

/**
 * 公司职位表
 */
public class EmployeePositionVO {

    /**
     * 员工职位ID
     */
    private Long positionId;

    /**
     * 员工职位名称
     */
    private String positionName;

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}