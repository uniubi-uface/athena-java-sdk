package com.uniubi.cloud.athena.sdk.common.models.response;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工信息响应
 * @author FeiMa
 */
public class EmployeeInfoResponse extends EmpBaseVO {

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
     * 性别文本 1:男 2:女
     */
    private String genderText;

    /**
     * 注册照地址，多个以英文逗号隔开
     */
    private String empPhotoUrls;

    /**
     * 入职日期
     */
    private LocalDateTime entryTime;

    /**
     * 座机
     */
    private String telNumber;

    /**
     * 办公地址
     */
    private String workPlace;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 用户密码（用于密码开门）
     */
    private String userPass;
    /**
     * 人员guid
     */
    private String personGuid;

    /**
     * 失败理由（用于人员导入模块展示信息）
     */
    private String reason;

    /**
     * 是否是超管 1:是 0:否 (一号员工为超管)
     */
    private Byte admin;

    /**
     * 员工头像
     */
    private String empPhoto;

    /**
     * 注册照信息
     */
    private List<EmpFaceVO> empFaceVOList;


    /**
     * 职称信息
     */
    private List<EmployeePositionVO> positionVOS;

    /**
     * 员工类型信息
     */
    private EmployeeTypeVO typeVO;

    /**
     * 人员分组信息
     */
    private EmployeeGroupVO groupVO;

    /**
     * 部门信息
     */
    private List<DepartmentDetailVO> departmentDetailVOS;


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

    public String getGenderText() {
        return genderText;
    }

    public void setGenderText(String genderText) {
        this.genderText = genderText;
    }

    public String getEmpPhotoUrls() {
        return empPhotoUrls;
    }

    public void setEmpPhotoUrls(String empPhotoUrls) {
        this.empPhotoUrls = empPhotoUrls;
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

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Byte getAdmin() {
        return admin;
    }

    public void setAdmin(Byte admin) {
        this.admin = admin;
    }

    public String getEmpPhoto() {
        return empPhoto;
    }

    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }

    public List<EmpFaceVO> getEmpFaceVOList() {
        return empFaceVOList;
    }

    public void setEmpFaceVOList(List<EmpFaceVO> empFaceVOList) {
        this.empFaceVOList = empFaceVOList;
    }

    public List<EmployeePositionVO> getPositionVOS() {
        return positionVOS;
    }

    public void setPositionVOS(List<EmployeePositionVO> positionVOS) {
        this.positionVOS = positionVOS;
    }

    public EmployeeTypeVO getTypeVO() {
        return typeVO;
    }

    public void setTypeVO(EmployeeTypeVO typeVO) {
        this.typeVO = typeVO;
    }

    public EmployeeGroupVO getGroupVO() {
        return groupVO;
    }

    public void setGroupVO(EmployeeGroupVO groupVO) {
        this.groupVO = groupVO;
    }

    public List<DepartmentDetailVO> getDepartmentDetailVOS() {
        return departmentDetailVOS;
    }

    public void setDepartmentDetailVOS(List<DepartmentDetailVO> departmentDetailVOS) {
        this.departmentDetailVOS = departmentDetailVOS;
    }
}
