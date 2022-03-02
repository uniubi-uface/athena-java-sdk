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
 * 考勤异常打卡数据展示对象
 *
 * @author jingmu
 */
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}
