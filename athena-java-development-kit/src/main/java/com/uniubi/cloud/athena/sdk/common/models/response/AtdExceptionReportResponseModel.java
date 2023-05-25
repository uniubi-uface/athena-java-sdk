package com.uniubi.cloud.athena.sdk.common.models.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 考勤异常打卡数据展示对象
 * @author jingmu
 */
public class AtdExceptionReportResponseModel {

    /**
     * 人员id
     */
    private String personId;

    /**
     * 员工编号
     */
    private String personNo;

    /**
     * 人员姓名
     */
    private String name;

    /**
     * 部门
     * <p>
     * department names
     */
    private List<String> depNames;

    /**
     * 职位
     */
    private List<String> roleNames;

    /**
     * 考勤日期
     * <p>
     * attendance date
     */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate atDate;

    /**
     * 打卡时间
     * <p>
     * clock time
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recognitionTime;

    /**
     * 打卡图片Id
     * <p>
     * clock scene photo ID
     */
    private String clockPhotoId;

    /**
     * 设备key
     * <p>
     * device SN.
     */
    private String deviceKey;

    /**
     * 设备名称
     */
    private String deviceName;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepNames() {
        return depNames;
    }

    public void setDepNames(List<String> depNames) {
        this.depNames = depNames;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    public LocalDate getAtDate() {
        return atDate;
    }

    public void setAtDate(LocalDate atDate) {
        this.atDate = atDate;
    }

    public LocalDateTime getRecognitionTime() {
        return recognitionTime;
    }

    public void setRecognitionTime(LocalDateTime recognitionTime) {
        this.recognitionTime = recognitionTime;
    }

    public String getClockPhotoId() {
        return clockPhotoId;
    }

    public void setClockPhotoId(String clockPhotoId) {
        this.clockPhotoId = clockPhotoId;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public String toString() {
        return "AtdExceptionReportResponseModel{" + "personId='" + personId + '\'' + ", personNo='" + personNo + '\''
            + ", name='" + name + '\'' + ", depNames=" + depNames + ", roleNames=" + roleNames + ", atDate="
            + atDate + ", recognitionTime=" + recognitionTime + ", clockPhotoId='" + clockPhotoId + '\''
            + ", deviceKey='" + deviceKey + '\'' + ", deviceName='" + deviceName + '\'' + '}';
    }

}
