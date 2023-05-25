package com.uniubi.cloud.athena.sdk.common.models.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 井木
 * @since 2021/04/14 19:22
 */
public class AtdOverWorkReportResponseModel {

    /**
     * 人员 id
     * <p>
     * data id
     */
    private String personId;

    /**
     * 员工编号
     * <p>
     * person NO.
     */
    private String personNo;

    /**
     * 人员姓名
     */
    private String name;

    /**
     * 部门 department names
     */
    private List<String> depNames;

    /**
     * 职位 role,position
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
     * 工作日加班时长 单位秒
     * <p>
     * Working day overtime duration unit: seconds
     */
    private Long workDayOverWorkSecond;

    /**
     * 休息日加班时长 单位秒
     * <p>
     * Overtime hours on rest days (unit: s)
     */
    private Long restDayOverWorkSecond;

    /**
     * 节假日加班时长 单位秒
     * <p>
     * Holiday overtime duration unit: seconds
     */
    private Long holidayOverWorkSecond;

    /**
     * 日期类型
     *
     * <ul>
     * <li>1-工作日(普通时间段)</li>
     * <li>2-工作日(弹性时间段)</li>
     * <li>3-休息日</li>
     * <li>4-节假日</li>
     * <li>5-未排班</li>
     * </ul>
     * <p>
     * <p>
     * Date type
     * <ul>
     * <li>1-working days (normal time period)</li>
     * <li>2-working days (flexible time period)</li>
     * <li>3-rest days</li>
     * <li>4-holidays</li>
     * <li>5-unscheduled shifts</li>
     * </ul>
     */
    private Byte dateType;

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

    public Long getWorkDayOverWorkSecond() {
        return workDayOverWorkSecond;
    }

    public void setWorkDayOverWorkSecond(Long workDayOverWorkSecond) {
        this.workDayOverWorkSecond = workDayOverWorkSecond;
    }

    public Long getRestDayOverWorkSecond() {
        return restDayOverWorkSecond;
    }

    public void setRestDayOverWorkSecond(Long restDayOverWorkSecond) {
        this.restDayOverWorkSecond = restDayOverWorkSecond;
    }

    public Long getHolidayOverWorkSecond() {
        return holidayOverWorkSecond;
    }

    public void setHolidayOverWorkSecond(Long holidayOverWorkSecond) {
        this.holidayOverWorkSecond = holidayOverWorkSecond;
    }

    public Byte getDateType() {
        return dateType;
    }

    public void setDateType(Byte dateType) {
        this.dateType = dateType;
    }

    @Override
    public String toString() {
        return "AtdOverWorkReportResponseModel{" + "personId='" + personId + '\'' + ", personNo='" + personNo + '\''
            + ", name='" + name + '\'' + ", depNames=" + depNames + ", roleNames=" + roleNames + ", atDate="
            + atDate + ", workDayOverWorkSecond=" + workDayOverWorkSecond + ", restDayOverWorkSecond="
            + restDayOverWorkSecond + ", holidayOverWorkSecond=" + holidayOverWorkSecond + ", dateType=" + dateType
            + '}';
    }

}
