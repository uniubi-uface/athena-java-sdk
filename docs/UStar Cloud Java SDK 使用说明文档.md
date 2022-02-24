# UStar Cloud Java SDK 使用说明文档

> 本文档仅适用于UStarCloud提供的Java SDK开发包
>
> 版本号与UStarCloud版本号对应

| SDK版本 | 修改时间 | 修改人 | 修改内容 |
| ---- | ---- | ---- | ---- |
| 2.3.0 | 2021-11-23 | 井木 | 编订 |

简要说明：演示代码中的资源数据均为模拟数据，测试代码开发运行于java1.8

## 1.快速使用

#### 第一步：申请对接账号

管理员在UStarCloud开发者接入平台页面，创建一个新的开发者平台

系统会自动为该新平台生成 accessKey 和 accessSecret，还有数据加解密用的 publicKey

#### 第二步：项目中引入开发包依赖

项目中引入离线客户端提供的开发jar包（athena-sdk.jar）

#### 第三步：快速使用

```java
public class DevelopQuickStart {

    public static void main(String[] args) {
        // 1.创建一个连接配置信息对象 RequestConfig
        RequestConfig requestConfig = new RequestConfig();
        // 设置连接超时时间（毫秒）
        requestConfig.setConnectionTimeoutMills(3000L);
        requestConfig.setReadTimeoutMills(3000L);
        // 设置公钥
        requestConfig.setPublicKey("公钥");
        // 设置连接服务地址
        requestConfig.setEndPoint("https://www.ustar-cloud.com");
        // 2.创建SDK统一客户端
        AthenaSdkKApiClient athenaSdkApiClient = new AthenaSdkApiClient("accessKey", "accessSecret", requestConfig);
        // 3.生成测试接口实例，直接调用，接口统一返回SdkResult对象
        SdkTestApi sdkTestApi = athenaSdkApiClient.createSdkTestApi();
        SdkResult<String> result = sdkTestApi.test();
        // 4.结果展示
        System.out.println(result);
    }
}

```

## 2.接口文档使用说明

### 2.1.公有对象说明

#### 2.1.1 统一结果返回

```java
public class SdkResult<T> {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回code码
     */
    private String code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 返回结果数据
     */
    private T data;
}
```

#### 2.1.2 分页结果返回

```java
public class SdkPageInfo<T> {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 页数
     */
    private Integer pages;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据集合
     */
    private List<T> list;
}
```

### 2.1 考勤报表

```java
	@Override
public void init() {
        atdReportApi = aresSDKApiClient.createSDKAtdReportApi();
        }
```

#### 2.1.1 考勤明细报表

```java
public void atdDetailReport() {
    AtdReportQueryRequest queryRequest = new AtdReportQueryRequest();
    SDKResult<SDKPageInfo<AtdDetailReportResponseModel>> res = atdReportApi.atdDetailReport(queryRequest);
    System.out.println(JSON.toJSONString(res));
}
```

参数说明：

```java
public class AtdReportQueryRequest {

    /*** 部门id */
    private String deptId;

    /*** 员工名称/编号 */
    private String empName;

    /*** 开始日期 yyyy-MM-dd */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate startDate;

    /*** 结束日期 yyyy-MM-dd */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate endDate;
    /**
     * 页码
     */
    private Integer pageNum = 1;
    /**
     * 每页限制条数
     */
    private Integer pageSize = 10;

}
```

返回值说明;

```java
public class AtdDetailReportResponseModel {

    /*** 人员id */
    private String personId;

    /*** 员工编号 */
    private String personNo;

    /*** 人员姓名 */
    private String name;

    /*** 部门 */
    @I18nProperty
    private List<String> depNames;

    /*** 职位 */
    private List<String> roleNames;

    /*** 日期 */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate atDate;

    /*** 时间段名称 */
    @I18nProperty
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
```

#### 2.1.2 考勤加班报表

```java
@Test
public void atdOverWorkReport() {
    AtdReportQueryRequest queryRequest = new AtdReportQueryRequest();
    SdkResult<SdkPageInfo<AtdOverWorkReportResponseModel>> res = atdReportApi.atdOverWorkReport(queryRequest);
    System.out.println(JSON.toJSONString(res));
}
```

参数说明：

```java
public class AtdReportQueryRequest {

    /*** 部门id */
    private String deptId;

    /*** 员工名称/编号 */
    private String empName;

    /*** 开始日期 yyyy-MM-dd */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate startDate;

    /*** 结束日期 yyyy-MM-dd */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate endDate;
    /**
     * 页码
     */
    private Integer pageNum = 1;
    /**
     * 每页限制条数
     */
    private Integer pageSize = 10;

}
```

返回值说明：

```java
public class AtdOverWorkReportResponseModel {

    /*** 人员id */
    private String personId;

    /*** 员工编号 */
    private String personNo;

    /*** 人员姓名 */
    private String name;

    /*** 部门 */
    @I18nProperty
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
```

#### 2.1.3 考勤休息报表

```java
@Test
public void atdOverWorkReport() {
    AtdReportQueryRequest queryRequest = new AtdReportQueryRequest();
    SDKResult<SDKPageInfo<AtdOverWorkReportResponseModel>> res = atdReportApi.atdOverWorkReport(queryRequest);
    System.out.println(JSON.toJSONString(res));
}
```

参数说明：

```java
public class AtdReportQueryRequest {

    /*** 部门id */
    private String deptId;

    /*** 员工名称/编号 */
    private String empName;

    /*** 开始日期 yyyy-MM-dd */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate startDate;

    /*** 结束日期 yyyy-MM-dd */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate endDate;
    /**
     * 页码
     */
    private Integer pageNum = 1;
    /**
     * 每页限制条数
     */
    private Integer pageSize = 10;

}
```

返回值说明：

```java
public class AtdOverWorkReportResponseModel {

    /*** 人员id */
    private String personId;

    /*** 员工编号 */
    private String personNo;

    /*** 人员姓名 */
    private String name;

    /*** 部门 */
    @I18nProperty
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
```

#### 2.1.4 考勤异常打卡报表

```java
@Test
public void atdExceptionReport() {
    AtdReportQueryRequest queryRequest = new AtdReportQueryRequest();
    SDKResult<SDKPageInfo<AtdExceptionReportResponseModel>> res = atdReportApi.atdExceptionReport(queryRequest);
    System.out.println(JSON.toJSONString(res));
}
```

参数说明：

```java
public class AtdReportQueryRequest {

    /*** 部门id */
    private String deptId;

    /*** 员工名称/编号 */
    private String empName;

    /*** 开始日期 yyyy-MM-dd */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate startDate;

    /*** 结束日期 yyyy-MM-dd */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate endDate;
    /**
     * 页码
     */
    private Integer pageNum = 1;
    /**
     * 每页限制条数
     */
    private Integer pageSize = 10;

}
```

返回值说明：

```java
public class AtdExceptionReportResponseModel {

    /*** 人员id */
    private String personId;

    /*** 员工编号 */
    private String personNo;

    /*** 人员姓名 */
    private String name;

    /*** 部门 */
    @I18nProperty
    private List<String> depNames;

    /*** 职位 */
    private List<String> roleNames;

    /*** 考勤日期 */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate atDate;

    /*** 打卡时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recognitionTime;

    /*** 打卡图片Id */
    private String clockPhotoId;

    /*** 设备key */
    private String deviceKey;

    /*** 设备名称 */
    private String deviceName;
}
```

## 3.响应回调消息说明

管理员登录离线客户端，在开发者对接平台页面，设置对接平台的回调地址，和需要回调的事件

离线客户端系统内部会监测当这些事件发生时会向关注了这些事件的对接平台发送这些事件的消息

如果消息发送因为网络原因导致了失败，系统会重试发送，目前重试次数最大为20次，每次间隔5分钟

### 3.1.消息统一返回结构说明

请求方式：POST

请求体：body

请求类型：application/json

请求体内容：

```java
public class MsgContentBO {
    /**
     * 消息id
     */
    private String msgId;
    /**
     * 消息类型
     * 1   识别记录推送
     * 2   员工添加记录推送
     * 3   员工更新记录推送
     * 4   员工删除记录推送
     * 5   部门添加记录推送
     * 6   部门更新记录推送
     * 7   部门删除记录推送
     */
    private Byte type;
    /**
     * 消息内容（不同消息内容格式也是不同的）
     */
    private String content;
}
```

要求成功返回格式：

```java
public class MsgResult {
    /**
     * 是否接收成功，返回true，系统就不会再处理该消息
     * 返回false，系统则会在5分钟后进行重试处理
     */
    private Boolean success;
}
```

**注意：处理系统回调消息时，只有正确返回了成功返回结果，才算这个消息处理成功，否则系统会一直重试**

**注意：会考虑消息重复消费问题，消息顺序性问题，消费端需要做好幂等性控制**

### 3.2.事件内容说明

#### 3.2.1.识别记录回调事件

触发条件：当设备识别记录回调到给系统时

识别记录回调内容：

```java
public class DeveloperRecognitionRecordVO {

    @ApiModelProperty("识别记录id")
    private Long id;

    @ApiModelProperty(value = "组织id", hidden = true)
    private Long orgId;

    @ApiModelProperty("识别记录类型1.员工2访客3陌生人")
    private Byte personType;

    @ApiModelProperty("设备序列号")
    private String deviceKey;

    @ApiModelProperty("设备名称")
    private String deviceName;

    @ApiModelProperty("人员id（访客id）")
    private Long personId;

    @ApiModelProperty("人员编号（用于员工）")
    private String empNo;

    @I18nProperty
    @ApiModelProperty("所属部门名称（用于员工）")
    private List<String> departmentNames;

    @ApiModelProperty("人员姓名")
    private String name;

    @ApiModelProperty("识别记录时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JSONField(serializeUsing = LocalDateTimeSerializer.class)
    private LocalDateTime showTime;

    @ApiModelProperty("活体结果 1:活体判断成功 2:活体判断失败 3:未进行活体判断")
    private Byte aliveType;

    @ApiModelProperty("识别模式,1:刷脸,2:刷卡,3:脸&卡双重认证, 4:人证比对")
    private Byte recMode;

    @ApiModelProperty("识别模式对比结果 1:成功 2失败")
    private Byte recStatus;

    @ApiModelProperty("1:本地识别 2云端识别")
    private Byte recType;

    @ApiModelProperty("识别结果 1成功2失败")
    private Byte type;

    @ApiModelProperty("现场照")
    private String photoUrl;

    @ApiModelProperty("有效日期判断 1:有效期内 2:有效期外 3:未进行有效期判断")
    private Byte permissionTimeType;

    @ApiModelProperty("有效时间段判断 1:时间段内 2:时间段外 3:未进行时间段判断")
    private Byte passTimeType;

    @ApiModelProperty("人员测量温度值(仅口罩测温设备支持)")
    private Double temperature;

    @ApiModelProperty("体温状态(仅口罩测温设备支持)1：正常 2：异常")
    private Byte temperatureState;

    @ApiModelProperty("温度单位(仅口罩测温设备支持)1. 摄氏度2. 华氏度")
    private Byte temperatureUnit;
}
```

