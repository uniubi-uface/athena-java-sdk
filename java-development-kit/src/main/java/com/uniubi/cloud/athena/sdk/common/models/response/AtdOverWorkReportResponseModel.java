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

    /*** 考勤日期 */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate atDate;

    /*** 工作日加班时长 单位秒 */
    private Long workDayOverWorkSecond;

    /*** 休息日加班时长 单位秒 */
    private Long restDayOverWorkSecond;

    /*** 节假日加班时长 单位秒 */
    private Long holidayOverWorkSecond;

    /*** 日期类型：1-工作日(普通时间段)，2-工作日(弹性时间段)，3-休息日，4-节假日，5-未排班 */
    private Byte dateType;

}
