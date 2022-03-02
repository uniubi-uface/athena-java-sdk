package com.uniubi.cloud.athena.sdk.common.models.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 井木
 * @since 2021/04/14 16:33
 */
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AtdDetailReportResponseModel {

    /**
     * 人员id
     * <p>
     * data ID
     */
    private String personId;

    /**
     * 员工编号
     * <p>
     * employee NO.
     */
    private String personNo;

    /**
     * 人员姓名
     * <p>
     * employee name
     */
    private String name;

    /**
     * 部门
     * <p>
     * department name.
     */
    private List<String> depNames;

    /**
     * 职位
     * <p>
     * role , position
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
     * <p>
     * time Interval name
     */
    private String timeIntervalName;

    /**
     * 应签到时间
     * <p>
     * plan Sign In Datetime
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planSignInDatetime;

    /**
     * 应签退时间
     * <p>
     * plan Sign Out Datetime
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planSignOutDatetime;

    /**
     * 时间段计划工作时长，单位秒
     * <p>
     * plan Time Interval Second，unit:second
     */
    private Long planTimeIntervalSecond;

    /**
     * 实际签到时间
     * <p>
     * real Sign In Time
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime realSignInTime;

    /**
     * 签到状态
     *
     * <ul>
     * <li>1 正常</li>
     * <li>2 缺卡</li>
     * <li>3 迟到</li>
     * <li>4 早退</li>
     * <li>5 未打卡(缺卡)</li>
     * <li>6 加班</li>
     * </ul>
     * <p>
     * sign in status
     * <ul>
     * <li>1 normal</li>
     * <li>2 missing</li>
     * <li>3 late</li>
     * <li>4 leave early</li>
     * <li>5 Not clocked in (missing)</li>
     * <li>6 work overtime</li>
     * </ul>
     */
    private Byte signInStatus;

    /**
     * 实际签退时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime realSignOutTime;

    /**
     * 签退状态
     *
     * <ul>
     * <li>1 正常</li>
     * <li>2 缺卡</li>
     * <li>3 迟到</li>
     * <li>4 早退</li>
     * <li>5 未打卡(缺卡)</li>
     * <li>6 加班</li>
     * </ul>
     * <p>
     * sign out status
     * <ul>
     * <li>1 normal</li>
     * <li>2 missing</li>
     * <li>3 late</li>
     * <li>4 leave early</li>
     * <li>5 Not clocked in (missing)</li>
     * <li>6 work overtime</li>
     * </ul>
     */
    private Byte signOutStatus;

    /**
     * 实际工作时长 单位秒
     * <p>
     * real WorkTime Second, unit: second
     */
    private Long realWorkTimeSecond;

    /**
     * 正常工作时长 单位秒
     * <p>
     * unit: second
     */
    private Long normalWorkSecond;

    /**
     * 迟到时长 单位秒
     * <p>
     * Length of lateness in seconds
     */
    private Long realLateSecond;

    /**
     * 早退时长 单位秒
     * <p>
     * Early leave duration unit: seconds
     */
    private Long realLeaveEarlySecond;

    /**
     * 旷工时长 单位秒
     * <p>
     * Absenteeism in seconds
     */
    private Long realAbsenteeismSecond;

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

    /**
     * 开始签到时间,当且仅当dateType=2时有值
     * <p>
     * Start check-in time. It has a value when and only when dateType = 2
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signInStart;

    /**
     * 结束签到时间,当且仅当dateType=2时有值
     * <p>
     * End check-in time. It has a value when and only when dateType = 2
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signInEnd;

}
