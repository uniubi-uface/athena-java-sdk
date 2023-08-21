package com.uniubi.cloud.athena.sdk.common.models.response;

/**
 * @author kalong
 */
public class EmployeeGroupVO {

    /**
     * 人员分组ID
     */
    private Long groupId;

    /**
     * 人员分组名称
     */
    private String groupName;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}