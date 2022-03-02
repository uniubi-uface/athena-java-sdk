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
 * @since 2021/04/14 19:34
 */
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
     *     <li>0 unsettled</li>
     *     <li>1 normal</li>
     *     <li>2 unsettled</li>
     * </ul>
     */
    private Byte breakStatus;

}
