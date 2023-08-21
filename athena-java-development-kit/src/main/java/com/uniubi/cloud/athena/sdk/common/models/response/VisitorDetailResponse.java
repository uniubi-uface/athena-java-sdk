package com.uniubi.cloud.athena.sdk.common.models.response;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author FeiMa
 */
public class VisitorDetailResponse {

    /**
     * 访客记录id
     */
    private Long recordId;

    /**
     * 来访人照片信息
     */
    private List<VisitorFaceResponse> visitFaceVOS;

    /**
     * 来访人姓名
     */
    private String visitorName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 被访人信息（json串）[{\"employeeId\":\"22\",\"employeeName\":\"Eric Gao\"},{},{}]
     */
    private String employeeInfoJson;

    /**
     * 访客状态 0未到访 1 访问中 2 已结束 3 已过期
     */
    private Byte visStatus;

    /**
     * 访客状态 0未到访 1 访问中 2 已结束 3 已过期
     */
    private String visStatusText;

    /**
     * 预约开始时间
     */
    private LocalDateTime visStartTime;

    /**
     * 预约结束时间
     */
    private LocalDateTime visEndTime;

    /**
     * 签入时间
     */
    private LocalDateTime signInTime;

    /**
     * 签出时间
     */
    private LocalDateTime signOutTime;

    /**
     * 来访人数
     */
    private Integer visitorNum;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 车牌号
     */
    private String visitorPlateNum;

    /**
     * 性别 1:男 2:女
     */
    private Byte gender;

    /**
     * 备注
     */
    private String remark;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 人员权限 刷脸权限 1：无权限；2：有权限
     */
    private Byte facePermission;

    /**
     * 人员权限 刷卡权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）
     */
    private Byte idCardPermission;

    /**
     * 人员权限 人卡合一权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）
     */
    private Byte faceAndCardPermission;

    /**
     * 人员权限 人证比对权限 1：无权限；2：有权限
     */
    private Byte idCardFacePermission;

    /**
     * 人员权限 密码开门 1：无权限；2：有权限
     */
    private Byte passwordPermission;

    /**
     * 来访事由
     */
    private String originStr;

    /**
     * 来源 0：web端来访登记；1：二维码登记
     */
    private Byte source;

}
