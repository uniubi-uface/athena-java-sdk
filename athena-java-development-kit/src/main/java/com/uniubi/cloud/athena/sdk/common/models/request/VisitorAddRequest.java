package com.uniubi.cloud.athena.sdk.common.models.request;

import java.time.LocalDateTime;

/**
 * 增加访客请求对象
 * @author FeiMa
 */
public class VisitorAddRequest {
    /**
     * 访客姓名
     */
    private String visitorName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 被访人信息（json串）[{\"empId\":1,\"empNo\":\"001\",\"name\":\"犀婴 \"},{{\"empId\":2,\"empNo\":\"10065\",\"name\":\"卡卡西 \"}]
     */
    private String employeeInfoJson;

    /**
     * 来访人数
     */
    private Integer visitorNum;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 车牌号
     */
    private String visitorPlateNum;

    /**
     * 性别 1:男 2:女
     */
    private Byte gender;

    /**
     * 备注
     */
    private String remark;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 预约开始时间
     */
    private LocalDateTime visStartTime;

    /**
     * 预约结束时间
     */
    private LocalDateTime visEndTime;

    /**
     * 人员权限 刷脸权限 1：无权限；2：有权限
     */
    private Byte facePermission;

    /**
     * 人员权限 刷卡权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）
     */
    private Byte idCardPermission;

    /**
     * 人员权限 人卡合一权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）
     */
    private Byte faceAndCardPermission;

    /**
     * 人员权限 人证比对权限 1：无权限；2：有权限"
     */
    private Byte idCardFacePermission;

    /**
     * 人员权限 密码开门 1：无权限；2：有权限
     */
    private Integer passwordPermission;

    /**
     * 来访事由
     */
    private String originStr;

    /**
     * 预约登记来源0：web来访登记，1：二维码登记（不填默认web来访登记）
     */
    private Byte source;

    public VisitorAddRequest() {
        this.idCardFacePermission = 1;
        this.passwordPermission = 1;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEmployeeInfoJson() {
        return employeeInfoJson;
    }

    public void setEmployeeInfoJson(String employeeInfoJson) {
        this.employeeInfoJson = employeeInfoJson;
    }

    public Integer getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(Integer visitorNum) {
        this.visitorNum = visitorNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVisitorPlateNum() {
        return visitorPlateNum;
    }

    public void setVisitorPlateNum(String visitorPlateNum) {
        this.visitorPlateNum = visitorPlateNum;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public LocalDateTime getVisStartTime() {
        return visStartTime;
    }

    public void setVisStartTime(LocalDateTime visStartTime) {
        this.visStartTime = visStartTime;
    }

    public LocalDateTime getVisEndTime() {
        return visEndTime;
    }

    public void setVisEndTime(LocalDateTime visEndTime) {
        this.visEndTime = visEndTime;
    }

    public Byte getFacePermission() {
        return facePermission;
    }

    public void setFacePermission(Byte facePermission) {
        this.facePermission = facePermission;
    }

    public Byte getIdCardPermission() {
        return idCardPermission;
    }

    public void setIdCardPermission(Byte idCardPermission) {
        this.idCardPermission = idCardPermission;
    }

    public Byte getFaceAndCardPermission() {
        return faceAndCardPermission;
    }

    public void setFaceAndCardPermission(Byte faceAndCardPermission) {
        this.faceAndCardPermission = faceAndCardPermission;
    }

    public Byte getIdCardFacePermission() {
        return idCardFacePermission;
    }

    public void setIdCardFacePermission(Byte idCardFacePermission) {
        this.idCardFacePermission = idCardFacePermission;
    }

    public Integer getPasswordPermission() {
        return passwordPermission;
    }

    public void setPasswordPermission(Integer passwordPermission) {
        this.passwordPermission = passwordPermission;
    }

    public String getOriginStr() {
        return originStr;
    }

    public void setOriginStr(String originStr) {
        this.originStr = originStr;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }
}
