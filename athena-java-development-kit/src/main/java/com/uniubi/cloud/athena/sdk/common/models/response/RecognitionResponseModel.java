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
 * @since 2020/5/18
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
     *
     * <ul>
     * <li>1 employee</li>
     * <li>2 visitor</li>
     * <li>3 stranger</li>
     * </ul>
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
     * <p>
     * alive body type
     * <ul>
     * <li>1 alive body</li>
     * <li>2 not alive body</li>
     * <li>3 No living judgment was performed</li>
     * </ul>
     */
    private Byte aliveType;

    /**
     * 识别模式,1:刷脸,2:刷卡,3:脸&卡双重认证, 4:人证比对
     * <p>
     * Recognition mode
     *
     * <ul>
     * <li>1 face</li>
     * <li>2 card</li>
     * <li>3 face & card</li>
     * <li>4 face & ID card</li>
     * </ul>
     */
    private Byte recMode;

    /**
     * 识别模式对比结果 1:成功 2失败
     * <p>
     * Recognition pattern comparison results
     *
     * <ul>
     * <li>1 success</li>
     * <li>2 failed</li>
     * </ul>
     */
    private Byte recStatus;

    /**
     * 1:本地识别 2云端识别
     * <p>
     * recognition side
     * <ul>
     * <li>1 local</li>
     * <li>2 cloud</li>
     * </ul>
     */
    private Byte recType;

    /**
     * 识别结果 1成功2失败 recognition result
     * <ul>
     * <li>1 success</li>
     * <li>2 failed</li>
     * </ul>
     */
    private Byte type;

    /**
     * 现场照
     * <p>
     * scene photo url, maybe ftp url
     */
    private String photoUrl;

    /**
     * 有效日期判断 1:有效期内 2:有效期外 3:未进行有效期判断
     * <p>
     * permissionTime Type
     *
     * <ul>
     * <li>1: Within the validity period</li>
     * <li>2: outside the validity period</li>
     * <li>3: the validity period is not judged</li>
     * </ul>
     */
    private Byte permissionTimeType;

    /**
     * 有效时间段判断 1:时间段内 2:时间段外 3:未进行时间段判断
     *
     * <p>
     * passTimeType
     * <ul>
     * <li>1: In time period</li>
     * <li>2: out of time period</li>
     * <li>3: no time period judgment</li>
     * </ul>
     */
    private Byte passTimeType;

    /**
     * 人员测量温度值(仅口罩测温设备支持)
     */
    private Double temperature;

    /**
     * 体温状态(仅口罩测温设备支持)1：正常 2：异常
     * <p>
     * temperature State
     * <ul>
     * <li>1 normal</li>
     * <li>2 abnormal</li>
     * </ul>
     */
    private Byte temperatureState;

    /**
     * 温度单位(仅口罩测温设备支持)1. 摄氏度2. 华氏度 temperature Unit
     * <ul>
     * <li>1 centigrade ℃</li>
     * <li>2 Fahrenheit degree ℉</li>
     * </ul>
     */
    private Byte temperatureUnit;

}
