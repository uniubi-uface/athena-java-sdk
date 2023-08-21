package com.uniubi.cloud.athena.sdk.common.models.response;

import java.util.List;

/**
 * @author xiying
 */
public class DepartmentDetailVO {

    /**
     * 部门id
     */
    private Long departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 上级部门 根部门上级为“-1”（根部门默认为公司名，不能修改）
     */
    private Long parentId;

    /**
     * 上级部门名称
     */
    private String parentDepartmentName;

    /**
     * 部门负责人id
     */
    private List<EmpBaseVO> empBaseList;

    /**
     * 是否是默认部门（0不是默认部门1是默认部门）
     */
    private Byte isDefault;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentDepartmentName() {
        return parentDepartmentName;
    }

    public void setParentDepartmentName(String parentDepartmentName) {
        this.parentDepartmentName = parentDepartmentName;
    }

    public List<EmpBaseVO> getEmpBaseList() {
        return empBaseList;
    }

    public void setEmpBaseList(List<EmpBaseVO> empBaseList) {
        this.empBaseList = empBaseList;
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }
}
