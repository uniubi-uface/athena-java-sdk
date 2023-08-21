package com.uniubi.cloud.athena.sdk.common.models.response;

/**
 * 部门人员
 * @author kalong
 */
public class DeptEmployeeVO {

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 员工id
     */
    private Long empId;

    /**
     * 名
     */
    private String firstName;

    /**
     * 姓
     */
    private String lastName;

    /**
     * firstName + lastName
     */
    private String empName;

    /**
     * 员工编号
     */
    private String empNo;

    /**
     * 人员头像
     */
    private String avatar;

    private String email;

    /**
     * 是否是部门leader
     */
    private Boolean deptLeader;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDeptLeader() {
        return deptLeader;
    }

    public void setDeptLeader(Boolean deptLeader) {
        this.deptLeader = deptLeader;
    }
}
