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

    /*** 人员id */
    private String personId;

    /*** 员工编号 */
    private String personNo;

    /*** 人员姓名 */
    private String name;

    /*** 部门 */
    private List<String> depNames;

    /*** 职位 */
    private List<String> roleNames;

    /*** 日期 */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate atDate;

    /*** 时间段名称 */
    private String timeIntervalName;

    /*** 应签到时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planSignInDatetime;

    /*** 应签退时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planSignOutDatetime;

    /*** 时间段计划工作时长，单位秒 */
    private Long planTimeIntervalSecond;

    /*** 实际签到时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime realSignInTime;

    /*** 签到状态 1正常 2缺卡 3迟到 4早退 5未打卡(缺卡) 6加班 */
    private Byte signInStatus;

    /*** 实际签退时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime realSignOutTime;

    /*** 签退状态 1正常 2缺卡 3迟到 4早退 5未打卡(缺卡) 6加班 */
    private Byte signOutStatus;

    /*** 实际工作时长 单位秒 */
    private Long realWorkTimeSecond;

    /*** 正常工作时长 单位秒 */
    private Long normalWorkSecond;

    /*** 迟到时长 单位秒 */
    private Long realLateSecond;

    /*** 早退时长 单位秒 */
    private Long realLeaveEarlySecond;

    /*** 旷工时长 单位秒 */
    private Long realAbsenteeismSecond;

    /*** 工作日加班时长 单位秒 */
    private Long workDayOverWorkSecond;

    /*** 休息日加班时长 单位秒 */
    private Long restDayOverWorkSecond;

    /*** 节假日加班时长 单位秒 */
    private Long holidayOverWorkSecond;

    /*** 日期类型：1-工作日(普通时间段)，2-工作日(弹性时间段)，3-休息日，4-节假日，5-未排班 */
    private Byte dateType;

    /*** 开始签到时间,当且仅当dateType=2时有值 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signInStart;

    /*** 结束签到时间,当且仅当dateType=2时有值 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signInEnd;

}
