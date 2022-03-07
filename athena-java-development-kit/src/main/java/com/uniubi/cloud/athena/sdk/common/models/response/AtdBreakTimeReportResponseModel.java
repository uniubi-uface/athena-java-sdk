package com.uniubi.cloud.athena.sdk.common.models.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 井木
 * @since 2021/04/14 19:34
 */
public class AtdBreakTimeReportResponseModel {

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
     */
    private List<String> depNames;

    /**
     * 职位
     */
    private List<String> roleNames;

    /**
     * 日期
     * <p>
     * attendance date
     */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate atDate;

    /**
     * 时间段名称
     */
    private String timeIntervalName;

    /**
     * 时间段的休息时段名称
     * <p>
     * break time name of time interval
     */
    private String breaktimeName;

    /**
     * 计划休息时长，单位秒
     * <p>
     * Planned rest duration, in seconds
     */
    private Long planBreakTimeDuration;

    /**
     * 实际开始休息时间
     */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDateTime realBreakTimeStart;

    /**
     * 实际结束休息时间
     */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDateTime realBreakTimeEnd;

    /**
     * 实际休息时长，单位秒
     * <p>
     * Actual rest duration, in seconds
     */
    private Long realBreakTimeDuration;

    /**
     * 休息状态：0-未结算，1-正常，2-异常
     * <p>
     * <p>
     * break status
     * <ul>
     * <li>0 unsettled</li>
     * <li>1 normal</li>
     * <li>2 unsettled</li>
     * </ul>
     */
    private Byte breakStatus;

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

    public String getTimeIntervalName() {
        return timeIntervalName;
    }

    public void setTimeIntervalName(String timeIntervalName) {
        this.timeIntervalName = timeIntervalName;
    }

    public String getBreaktimeName() {
        return breaktimeName;
    }

    public void setBreaktimeName(String breaktimeName) {
        this.breaktimeName = breaktimeName;
    }

    public Long getPlanBreakTimeDuration() {
        return planBreakTimeDuration;
    }

    public void setPlanBreakTimeDuration(Long planBreakTimeDuration) {
        this.planBreakTimeDuration = planBreakTimeDuration;
    }

    public LocalDateTime getRealBreakTimeStart() {
        return realBreakTimeStart;
    }

    public void setRealBreakTimeStart(LocalDateTime realBreakTimeStart) {
        this.realBreakTimeStart = realBreakTimeStart;
    }

    public LocalDateTime getRealBreakTimeEnd() {
        return realBreakTimeEnd;
    }

    public void setRealBreakTimeEnd(LocalDateTime realBreakTimeEnd) {
        this.realBreakTimeEnd = realBreakTimeEnd;
    }

    public Long getRealBreakTimeDuration() {
        return realBreakTimeDuration;
    }

    public void setRealBreakTimeDuration(Long realBreakTimeDuration) {
        this.realBreakTimeDuration = realBreakTimeDuration;
    }

    public Byte getBreakStatus() {
        return breakStatus;
    }

    public void setBreakStatus(Byte breakStatus) {
        this.breakStatus = breakStatus;
    }

    @Override
    public String toString() {
        return "AtdBreakTimeReportResponseModel{" + "personId='" + personId + '\'' + ", personNo='" + personNo + '\''
                + ", name='" + name + '\'' + ", depNames=" + depNames + ", roleNames=" + roleNames + ", atDate="
                + atDate + ", timeIntervalName='" + timeIntervalName + '\'' + ", breaktimeName='" + breaktimeName + '\''
                + ", planBreakTimeDuration=" + planBreakTimeDuration + ", realBreakTimeStart=" + realBreakTimeStart
                + ", realBreakTimeEnd=" + realBreakTimeEnd + ", realBreakTimeDuration=" + realBreakTimeDuration
                + ", breakStatus=" + breakStatus + '}';
    }

}
