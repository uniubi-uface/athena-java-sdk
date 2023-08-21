package com.uniubi.cloud.athena.sdk.common.models.request;


import java.time.LocalDateTime;

/**
 * @author FeiMa
 */

public class EmployeeRegisterRequest {

    /**
     * 主键
     */
    private Long id;
    /**
     * 名
     */
    private String firstName;
    /**
     * 姓
     */
    private String lastName;
    /**
     * 所属部门id，多个以英文逗号隔开
     */
    private String departmentIds;
    /**
     * 员工编号
     */
    private String empNo;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 性别 1:男 2:女
     */
    private Byte gender;
    /**
     * 职称，多个以英文逗号隔开
     */
    private String empPositionIds;
    /**
     * 入职日期
     */
    private LocalDateTime entryTime;
    /**
     * 座机
     */
    private String telNumber;
    /**
     * 员工类型
     */
    private Long empType;
    /**
     * 人员分组ID
     */
    private Long groupId;
    /**
     * 办公地址
     */
    private String workPlace;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 用户密码
     */
    private String userPass;
    /**
     * 企业信息
     */
    private Long orgId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(String departmentIds) {
        this.departmentIds = departmentIds;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getEmpPositionIds() {
        return empPositionIds;
    }

    public void setEmpPositionIds(String empPositionIds) {
        this.empPositionIds = empPositionIds;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Long getEmpType() {
        return empType;
    }

    public void setEmpType(Long empType) {
        this.empType = empType;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
