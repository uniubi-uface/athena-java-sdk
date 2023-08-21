package com.uniubi.cloud.athena.sdk.common.models.response;

import java.util.List;

/**
 * @author kalong
 */
public class DeptTreeVO {

    private Long parentDeptId;

    private Long deptId;

    private String deptName;

    private List<DeptTreeVO> children;

    /**
     * 部门员工
     */
    private List<DeptEmployeeVO> deptEmployeeList;

    public Long getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(Long parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<DeptTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<DeptTreeVO> children) {
        this.children = children;
    }

    public List<DeptEmployeeVO> getDeptEmployeeList() {
        return deptEmployeeList;
    }

    public void setDeptEmployeeList(List<DeptEmployeeVO> deptEmployeeList) {
        this.deptEmployeeList = deptEmployeeList;
    }
}
