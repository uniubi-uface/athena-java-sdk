package com.uniubi.cloud.athena.sdk.common.models.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 井木
 * @since 2021/04/14 19:22
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
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

}
