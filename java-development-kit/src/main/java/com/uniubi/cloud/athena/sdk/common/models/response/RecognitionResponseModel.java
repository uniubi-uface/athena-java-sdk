package com.uniubi.cloud.athena.sdk.common.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * com.uniubi.medusa.ares.develop.models.response.RecognitionResponseModel
 *
 * @author jingmu
 * @date 2020/5/18
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class RecognitionResponseModel {

    /**
     * 识别记录id
     */
    private Long id;

    /**
     * 识别记录类型 1.员工 2访客 3陌生人
     */
    private Byte personType;

    /**
     * 设备序列号
     */
    private String deviceKey;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 人员id（访客id）
     */
    private Long personId;

    /**
     * 人员编号（用于员工）
     */
    private String empNo;

    /**
     * 所属部门名称（用于员工）
     */
    private List<String> departmentNames;

    /**
     * 人员姓名
     */
    private String name;

    /**
     * 识别记录时间 utc 时间戳
     */
    private Long recTimeMillis;

    /**
     * 活体结果 1:活体判断成功 2:活体判断失败 3:未进行活体判断
     */
    private Byte aliveType;

    /**
     * 识别模式,1:刷脸,2:刷卡,3:脸&卡双重认证, 4:人证比对
     */
    private Byte recMode;

    /**
     * 识别模式对比结果 1:成功 2失败
     */
    private Byte recStatus;

    /**
     * 1:本地识别 2云端识别
     */
    private Byte recType;

    /**
     * 识别结果 1成功2失败
     */
    private Byte type;

    /**
     * 现场照
     */
    private String photoUrl;

    /**
     * 有效日期判断 1:有效期内 2:有效期外 3:未进行有效期判断
     */
    private Byte permissionTimeType;

    /**
     * 有效时间段判断 1:时间段内 2:时间段外 3:未进行时间段判断
     */
    private Byte passTimeType;

    /**
     * 人员测量温度值(仅口罩测温设备支持)
     */
    private Double temperature;

    /**
     * 体温状态(仅口罩测温设备支持)1：正常 2：异常
     */
    private Byte temperatureState;

    /**
     * 温度单位(仅口罩测温设备支持)1. 摄氏度2. 华氏度
     */
    private Byte temperatureUnit;

}
