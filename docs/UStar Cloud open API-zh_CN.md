# 接口

## 1 鉴权API

### 1.1 获取sdkAccessToken

* sdkRequestKey : `authToken`

* 请求参数说明

  | 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                                        |
          | ----------------- | ------ | -------- | -------- | ------------------------------------------- |
  | accessKey         | body   | String   | true     | 开发者接入平台页面获取                      |
  | nonce             | body   | String   | true     | 随机数                                      |
  | encrypted         | body   | String   | true     | accessSecret+nonce得到的结果再进行MD5取摘要 |
  | sdkRequestKey     | header | String   | true     | sdkRequestKey 放在请求头中                  |
  | requestKeyVersion | header | String   | true     | v2                                          |
  | Content-Type      | header | String   | true     | application/json                            |

* 请求示例

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: authToken' \
  --header 'requestKeyVersion: v2' \
  --header 'Content-Type: application/json' \
  --data '{
      "accessKey": "fff4b1d9f7054bd8bab523b43004ad3b",
      "encrypted": "9E08207FBC6A8B3AAB21EF6B979F2EFA",
      "nonce": "123456"
  }'
  ```
* 响应参数

  | 字段名称 | 参数类型 | 说明                                             |
          | :------- | :------- | :----------------------------------------------- |
  | code     | String   | 返回参数的code，`1000_SUS`表示成功，其他表示失败 |
  | success  | boolean  | `true`表示成功，`false`表示失败                  |
  | msg      | String   | `successful operation!`  or `operation failed!`  |
  | data     | String   | sdkAccessToken,有效期为1天，失效重新过去即可     |

* 响应参数说明

  ```json
    {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": "d3b86512301c456ca96a90c4be1eccf4"
    }
  ```

### 1.2 测试接口

* sdkRequestKey : `test`

* 请求参数说明：

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
  | ----------------- | ------ | -------- | -------- | -------------------------- |
| sdkRequestKey     | header | String   | true     | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | true     | v2                         |
| sdkAccessToken    | header | String   | true     | sdkAccessToken             |
| Content-Type      | header | String   | true     | application/json           |
|                   | body   | String   |          | 随意输入                   |

* 请求示例

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: test' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data 'My name is Bright'
  ```

* 响应参数说明：

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": "Hey boy, welcome to UStar Cloud developer platform! The data you input is My name is Bright"
  }
  ```

## 2 考勤报表相关API

### 2.1 考勤明细报表

* sdkRequestKey : `atdDetailReport`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| pageNum           | body   | Integer  | Y        | 页码                       |
| pageSize          | body   | Integer  | Y        | 每页限制条数               |
| deptId            | body   | String   | N        | 部门id                     |
| empName           | body   | String   | N        | 员工名称/编号              |
| startDate         | body   | date     | N        | 开始日期 yyyy-MM-dd        |
| endDate           | body   | date     | N        | 结束日期 yyyy-MM-dd        |
| sdkRequestKey     | header | String   | true     | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | true     | v2                         |
| sdkAccessToken    | header | String   | true     | sdkAccessToken             |
| Content-Type      | header | String   | true     | application/json           |

* 请求示例

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: atdDetailReport' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
      "pageSize": 1,
      "pageNum": 1
  }'
  ```


* 响应参数说明

| 字段名称               | 字段类型     | 说明                                                         |
    | ---------------------- | ------------ | ------------------------------------------------------------ |
| personId               | String       | 人员id                                                       |
| personNo               | String       | 员工编号                                                     |
| name                   | String       | 人员姓名                                                     |
| depNames               | String array | 部门名称集合                                                 |
| roleNames              | String array | 职位名称集合                                                 |
| atDate                 | date         | 日期 yyyy-MM-dd                                              |
| timeIntervalName       | String       | 时间段名称                                                   |
| planSignInDatetime     | Date         | 应签到时间 yyyy-MM-dd HH:mm:ss                               |
| planSignOutDatetime    | Date         | 应签退时间 yyyy-MM-dd HH:mm:ss                               |
| planTimeIntervalSecond | long number  | 时间段计划工作时长，单位秒                                   |
| realSignInTime         | Date         | 实际签到时间 yyyy-MM-dd HH:mm:ss                             |
| signInStatus           | number       | 签到状态<br />1:正常<br />2:缺卡<br />3:迟到<br />4:早退<br />5:未打卡(缺卡)<br />6:加班 |
| realSignOutTime        | date         | 实际签退时间 yyyy-MM-dd HH:mm:ss                             |
| signOutStatus          | number       | 签退状态<br />1:正常<br />2:缺卡<br />3:迟到<br />4:早退<br />5:未打卡(缺卡)<br />6:加班 |
| realWorkTimeSecond     | long number  | 实际工作时长 单位秒                                          |
| normalWorkSecond       | long number  | 正常工作时长 单位秒                                          |
| realLateSecond         | long number  | 迟到时长 单位秒                                              |
| realLeaveEarlySecond   | long number  | 早退时长 单位秒                                              |
| realAbsenteeismSecond  | long number  | 旷工时长 单位秒                                              |
| workDayOverWorkSecond  | long number  | 工作日加班时长 单位秒                                        |
| restDayOverWorkSecond  | long number  | 休息日加班时长 单位秒                                        |
| holidayOverWorkSecond  | long number  | 节假日加班时长 单位秒                                        |
| dateType               | number       | 1 工作日(普通时间段)<br />2 工作日(弹性时间段)<br />3 休息日<br />4 节假日<br />5 未排班<br /> |
| signInStart            | Date         | 开始签到时间,当且仅当dateType=2时有值                        |
| signInEnd              | Date         | 结束签到时间,当且仅当dateType=2时有值                        |

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": {
          "pageNum": 1,
          "pageSize": 1,
          "pages": 282,
          "total": 282,
          "list": [
              {
                  "personId": "123",
                  "personNo": "person1002",
                  "name": "Lucy1 ",
                  "depNames": [
                      "Document group"
                  ],
                  "roleNames": [
                      "Product manager"
                  ],
                  "atDate": "2023-05-24",
                  "timeIntervalName": "朝九晚五",
                  "planSignInDatetime": "2023-05-25 16:00:00",
                  "planSignOutDatetime": "2023-05-26 01:00:00",
                  "planTimeIntervalSecond": 32400,
                  "realSignInTime": null,
                  "signInStatus": 2,
                  "realSignOutTime": null,
                  "signOutStatus": 5,
                  "realWorkTimeSecond": 0,
                  "normalWorkSecond": 0,
                  "realLateSecond": 0,
                  "realLeaveEarlySecond": 0,
                  "realAbsenteeismSecond": 0,
                  "workDayOverWorkSecond": 0,
                  "restDayOverWorkSecond": 0,
                  "holidayOverWorkSecond": 0,
                  "dateType": 1,
                  "signInStart": null,
                  "signInEnd": null
              }
          ]
      }
  }
  ```

### 2.2 加班报表

* sdkRequestKey : `atdOverWorkReport`

* 请求参数说明

| 字段名称  | 位置 | 字段类型 | 是否必须 | 说明                |
    | --------- | -------- | -------- | ------------------- | ------------------- |
| pageNum   | body | Integer  | Y        | 页码                |
| pageSize  | body | Integer  | Y        | 每页限制条数        |
| deptId    | body | String   | N        | 部门id              |
| empName   | body | String   | N        | 员工名称/编号       |
| startDate | body | date     | N        | 开始日期 yyyy-MM-dd |
| endDate   | body | date     | N        | 结束日期 yyyy-MM-dd |
| sdkRequestKey     | header | String   | true     | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | true     | v2                         |
| sdkAccessToken    | header | String   | true     | sdkAccessToken             |
| Content-Type      | header | String   | true     | application/json           |

* 请求示例

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: atdOverWorkReport' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
      "pageSize": 2,
      "pageNum": 1
  }'
  ```


* 响应参数说明

| 字段名称              | 字段类型     | 说明                                                         |
    | --------------------- | ------------ | ------------------------------------------------------------ |
| personId              | String       | 人员id                                                       |
| personNo              | String       | 员工编号                                                     |
| name                  | String       | 人员姓名                                                     |
| depNames              | String array | 部门名称集合                                                 |
| roleNames             | String array | 职位名称集合                                                 |
| atDate                | date         | 日期 yyyy-MM-dd                                              |
| workDayOverWorkSecond | long number  | 工作日加班时长 单位秒                                        |
| restDayOverWorkSecond | long number  | 休息日加班时长 单位秒                                        |
| holidayOverWorkSecond | long number  | 节假日加班时长 单位秒                                        |
| dateType              | number       | 1 工作日(普通时间段)<br />2 工作日(弹性时间段)<br />3 休息日<br />4 节假日<br />5 未排班<br /> |

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": {
          "pageNum": 1,
          "pageSize": 2,
          "pages": 141,
          "total": 282,
          "list": [
              {
                  "personId": "123",
                  "personNo": "person1002",
                  "name": "Lucy1 ",
                  "depNames": [
                      "Document group"
                  ],
                  "roleNames": [
                      "Product manager"
                  ],
                  "atDate": "2023-05-24",
                  "workDayOverWorkSecond": 0,
                  "restDayOverWorkSecond": 0,
                  "holidayOverWorkSecond": 0,
                  "dateType": 1
              },
              {
                  "personId": "124",
                  "personNo": "person1003",
                  "name": "Lucy2 ",
                  "depNames": [
                      "-待分配-"
                  ],
                  "roleNames": [],
                  "atDate": "2023-05-24",
                  "workDayOverWorkSecond": 0,
                  "restDayOverWorkSecond": 0,
                  "holidayOverWorkSecond": 0,
                  "dateType": 1
              }
          ]
      },
      "secret": null
  }
  ```

### 2.3 考勤休息报表

* sdkRequestKey : `atdBreakTimeReport`

* 请求参数说明

| 字段名称  | 位置 | 字段类型 | 是否必须 | 说明                |
    | --------- | ---- | -------- | -------- | ------------------- |
| pageNum   | body | Integer  | Y        | 页码                |
| pageSize  | body | Integer  | Y        | 每页限制条数        |
| deptId    | body | String   | N        | 部门id              |
| empName   | body | String   | N        | 员工名称/编号       |
| startDate | body | date     | N        | 开始日期 yyyy-MM-dd |
| endDate   | body | date     | N        | 结束日期 yyyy-MM-dd |
| sdkRequestKey     | header | String   | true     | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | true     | v2                         |
| sdkAccessToken    | header | String   | true     | sdkAccessToken             |
| Content-Type      | header | String   | true     | application/json           |

* 请求示例

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: atdBreakTimeReport' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
      "pageSize": 1,
      "pageNum": 1
  }'
  ```


* 响应参数说明

| 字段名称              | 字段类型     | 说明                               |
    | --------------------- | ------------ | ---------------------------------- |
| personId              | String       | 人员id                             |
| personNo              | String       | 员工编号                           |
| name                  | String       | 人员姓名                           |
| depNames              | String array | 部门名称集合                       |
| roleNames             | String array | 职位名称集合                       |
| atDate                | date         | 日期 yyyy-MM-dd                    |
| timeIntervalName      | String       | 时间段名称                         |
| breatimeName          | String       | 时间段的休息时段名称               |
| planBreakTimeDuration | long number  | 计划休息时长，单位秒               |
| realBreakTimeStart    | Date         | 实际开始休息时间 yyyy-MM-dd        |
| realBreakTimeEnd      | Date         | 实际结束休息时间 yyyy-MM-dd        |
| realBreakTimeDuration | long number  | 实际休息时长，单位秒               |
| breakStatus           | number       | 休息状态：0-未结算，1-正常，2-异常 |

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": {
          "pageNum": 1,
          "pageSize": 1,
          "pages": 30,
          "total": 30,
          "list": [
              {
                  "personId": "128",
                  "personNo": "person1007",
                  "name": "Lucy6 ",
                  "depNames": [
                      "-待分配-"
                  ],
                  "roleNames": [],
                  "atDate": "2022-03-21",
                  "timeIntervalName": "zaoban",
                  "breaktimeName": "xiuxi",
                  "planBreakTimeDuration": 120,
                  "realBreakTimeStart": null,
                  "realBreakTimeEnd": null,
                  "realBreakTimeDuration": null,
                  "breakStatus": 2
              }
          ]
      }
  }
  ```

### 2.4 考勤异常打卡报表

* sdkRequestKey : `atdExceptionReport`

* 请求参数说明

| 字段名称  | 位置 | 字段类型 | 是否必须 | 说明                |
    | --------- | ---- | -------- | -------- | ------------------- |
| pageNum   | body | Integer  | Y        | 页码                |
| pageSize  | body | Integer  | Y        | 每页限制条数        |
| deptId    | body | String   | N        | 部门id              |
| empName   | body | String   | N        | 员工名称/编号       |
| startDate | body | date     | N        | 开始日期 yyyy-MM-dd |
| endDate   | body | date     | N        | 结束日期 yyyy-MM-dd |

* 请求示例

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: atdExceptionReport' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
      "pageSize": 2,
      "pageNum": 1
  }'
  ```

* 响应参数说明

| 字段名称        | 字段类型     | 说明                         |
    | --------------- | ------------ | ---------------------------- |
| personId        | String       | 人员id                       |
| personNo        | String       | 员工编号                     |
| name            | String       | 人员姓名                     |
| depNames        | String array | 部门名称集合                 |
| roleNames       | String array | 职位名称集合                 |
| atDate          | date         | 日期 yyyy-MM-dd              |
| recognitionTime | Date         | 打卡时间 yyyy-MM-dd HH:mm:ss |
| clockPhotoId    | String       | 卡图片Id                     |
| deviceKey       | String       | 设备key                      |
| deviceName      | String       | 设备名称                     |
| sdkRequestKey     | header | String   | true     | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | true     | v2                         |
| sdkAccessToken    | header | String   | true     | sdkAccessToken             |
| Content-Type      | header | String   | true     | application/json           |

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": {
          "pageNum": 1,
          "pageSize": 10,
          "pages": 0,
          "total": 0,
          "list": [
              
          ]
      },
      "secret": null
  }
  ```

# 事件订阅回调

> 管理员登录UStar客户端，在开发者对接平台页面，设置对接平台的回调地址和关注的事件
> UStar客户端系统内部会监测当这些事件发生时会向关注了这些事件的对接平台发送这些事件的消息
> 如果消息发送因为网络原因导致了失败，系统会重试发送，目前重试次数最大为20次，每次间隔5分钟

UStar Cloud 会向各开发平台配置的地址发送http请求，请求方法使用POST。

## 事件消息结构说明

* 请求方法：`POST`

* 请求类型：`application/json`

* 请求体内容：

| 字段名称 | 字段类型 | 说明                                   |
    | -------- | -------- | -------------------------------------- |
| msgId    | String   | 消息id                                 |
| type     | number   | 消息类型 详细请参考数据字典[3.4](#3.4) |
| content  | String   | 消息内容为事件回调内容的json 字符串    |

> 请求体示例：
>
> ```json
> {
>     "msgId": "xxxxxxxx",
>     "type": 1,
>     "content": "{\"aliveType\":1,\"depNameConcat\":\"name1,name2\",\"departmentNames\":[\"name1\",\"name2\"],\"deviceKey\":\"84E0F42C3BB78702\",\"deviceName\":\"this is device name\",\"empNo\":\"001\",\"id\":3126713,\"name\":\"Joey T\",\"orgId\":97,\"passTimeType\":1,\"permissionTimeType\":1,\"personGuid\":null,\"personId\":8508,\"personType\":1,\"photoUrl\":\"https://uniubi-aiot.s3-eu-west-1.amazonaws.com/pkg365/2005/20050001000506/034000.411/img/ffe1fd7d-eecc-45c3-a6cf-14cee5c3361a.station\",\"recMode\":1,\"recStatus\":null,\"recType\":1,\"showTime\":\"2022-05-20 03:39:59\",\"temperature\":null,\"temperatureState\":null,\"temperatureUnit\":null,\"type\":1}"
> }
> ```

**为了方便对接，UStarCloud将根据请求的 HTTP status code 是否为 200 来决定是否需要重新发送**

> HTTP status code = 200 表示开发平台已成功处理消息推送，UStarCloud将不会重试。
>
> HTTP status code != 200 表示开发平台处理消息失败，UStarCloud将继续重试。
>
> 所以，朋友们，如果处理消息失败了，请将 HTTP status code 不要设置为200

## 回调事件

### 识别记录回调事件

* 触发条件：当设备识别记录回调到给系统时

* 事件回调内容：

| 字段名称           | 字段类型     | 说明                                                         |
    | ------------------ | ------------ | ------------------------------------------------------------ |
| id                 | number       | 识别记录id                                                   |
| orgId              | number       | 公司id                                                       |
| personType         | number       | 识别记录类型<br />1:员工;<br />2:访客;<br />3:陌生人         |
| deviceKey          | String       | 识别设备序列号                                               |
| deviceName         | String       | 设备名称                                                     |
| personId           | Long         | 人员id或者访客id                                             |
| empNo              | String       | 人员编号                                                     |
| departmentNames    | string array | 所属部门名称（用于员工）                                     |
| name               | String       | 人员姓名                                                     |
| showTime           | Date         | 识别时间，格式：yyyy-MM-dd HH:mm:ss                          |
| temperatureUnit    | number       | 体温单位 <br />1：摄氏度 <br />2：华氏度                     |
| temperatureState   | number       | 体温状态 <br />1：正常 <br />2：异常 <br />3：未设置<br />4：未测量体温 (兼容null的情况，null也是未测量或者无测温功能)**** |
| aliveBody          | number       | 活体判断 <br />1：活体<br />2：非活体<br />3：未进行活体判断 |
| permissionTimeType | number       | 有效时间段判断 <br />1:准入时间内<br />2:未在准入时间内<br />3:未进行有效期判断 |
| passTimeType       | number       | 有效日期判断 <br />1:有效期内<br />2:未在有效期内<br />3:未进行时间段判断 |
| recMode            | number       | 识别模式<br />1:刷脸,<br />2:刷卡,<br />3:脸&卡双重认证<br />4:人证比对 |
| recStatus          | number       | 识别模式对比结果 <br />1:成功 <br />2:失败                   |
| recType            | number       | 1:本地识别<br />2云端识别                                    |
| type               | number       | 识别结果 <br />1:成功;<br />2:失败                           |
| photoUrl           | String       | 现场照URL                                                    |

## 5 员工服务相关API

### 5.1 新注册员工信息

* sdkRequestKey : `registerEmployee`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| firstName         | body   | String   | Y        | 名                            |
| lastName          | body   | String   | Y        | 姓                            |
| departmentIds     | body   | String   | N        | 所属部门id，多个以英文逗号隔开                     |
| empNo             | body   | String   | Y        | 员工编号                        |
| mail              | body   | String   | N        | 邮箱                           |
| mobile            | body   | String   | N        | 手机号                          |
| gender            | body   | Byte     | N        | 性别 1:男 2:女                  |
| empPositionIds    | body   | String   | N        | 职称，多个以英文逗号隔开              |
| entryTime         | body   | date     | N        | 入职日期 yyyy-MM-dd             |
| telNumber         | body   | String   | N        | 座机        |
| empType           | body   | Long     | N        | 员工类型        |
| groupId           | body   | Long     | N        | 人员分组ID        |
| workPlace         | body   | String   | N        | 办公地址        |
| cardNo            | body   | String   | N        | 卡号        |
| userPass          | body   | String   | N        | 用户密码        |
| orgId             | body   | Long     | Y        | 企业id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例
  
```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: registerEmployee' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "firstName":"uniubi",
        "lastName":"feima",
        "orgId":1,
        "gender":1,
        "empNo":"1111",
        "mail":"feima@uniubi.com"
}'
```


* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```

### 5.2 添加员工照片

* sdkRequestKey : `addEmployeeFace`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| photoBase64       | body   | String   | Y        | 用户照片base64位编码字符                            |
| empNo             | body   | String   | Y        | 员工编号                        |
| orgId             | body   | Long     | Y        | 企业id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: addEmployeeFace' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "photoBase64":"....",
        "orgId":1,
        "empNo":"1111"
}'
```


* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```


### 5.3 编辑修改员工信息

* sdkRequestKey : `editEmployee`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| id                | body   | Long     | Y        | 员工id                            |
| firstName         | body   | String   | Y        | 名                            |
| lastName          | body   | String   | Y        | 姓                            |
| departmentIds     | body   | String   | N        | 所属部门id，多个以英文逗号隔开                     |
| empNo             | body   | String   | Y        | 员工编号                        |
| mail              | body   | String   | N        | 邮箱                           |
| mobile            | body   | String   | N        | 手机号                          |
| gender            | body   | Byte     | N        | 性别 1:男 2:女                  |
| empPositionIds    | body   | String   | N        | 职称，多个以英文逗号隔开              |
| entryTime         | body   | date     | N        | 入职日期 yyyy-MM-dd             |
| telNumber         | body   | String   | N        | 座机        |
| empType           | body   | Long     | N        | 员工类型        |
| groupId           | body   | Long     | N        | 人员分组ID        |
| workPlace         | body   | String   | N        | 办公地址        |
| cardNo            | body   | String   | N        | 卡号        |
| userPass          | body   | String   | N        | 用户密码        |
| orgId             | body   | Long     | Y        | 企业id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: registerEmployee' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "id":311,
        "firstName":"uni",
        "lastName":"feima",
        "orgId":1,
        "gender":1,
        "empNo":"1111",
        "mail":"feima@uniubi.com"
}'
```


* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```


### 5.4 查询员工信息

* sdkRequestKey : `queryEmployeeInfo`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| empNo             | body   | String   | Y        | 员工编号                        |
| orgId             | body   | Long     | Y        | 企业id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: addEmployeeFace' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "orgId":1,
        "empNo":"1111"
}'
```


* 响应参数说明

* 响应示例

| 字段名称          | 位置   | 字段类型 | 说明                       |
    | ----------------- | ------ | -------- | -------------------------- |
| empId                | body   | Long     | 员工id                            |
| firstName         | body   | String   | 名                            |
| lastName          | body   | String   | 姓                            |
| empName           | body   | String   | 员工全名称                            |
| departmentIds     | body   | String   | 所属部门id，多个以英文逗号隔开                     |
| empNo             | body   | String   | 员工编号                        |
| mail              | body   | String   | 邮箱                           |
| mobile            | body   | String   | 手机号                          |
| gender            | body   | Byte     | 性别 1:男 2:女                  |
| genderText        | body   | String     | 性别 1:男 2:女                  |
| empPhotoUrls      | body   | String     | 注册照地址，多个以英文逗号隔开                 |
| empPositionIds    | body   | String   | 职称，多个以英文逗号隔开              |
| entryTime         | body   | date     | 入职日期 yyyy-MM-dd             |
| telNumber         | body   | String   | 座机        |
| empType           | body   | Long     | 员工类型        |
| groupId           | body   | Long     | 人员分组ID        |
| workPlace         | body   | String   | 办公地址        |
| cardNo            | body   | String   | 卡号        |
| userPass          | body   | String   | 用户密码        |
| orgId             | body   | Long     | 企业id        |
| personGuid        | body   | String   | 人员guid        |
| empPhoto          | body   | String   | 员工头像        |
| empFaceVOList     | body   | List   | 注册照信息集合        |
| - empFaceId         | empFaceVOList   | Long   | 员工注册照id        |
| - empFaceUrl        | empFaceVOList   | String   | 员工注册照Url        |
| - cardNo            | empFaceVOList   | String   | 员工卡号        |
| departmentDetailVOS     | body   | List   | 部门信息集合        |
| - departmentId     | empFaceVOList   | Long   | 部门id        |
| - departmentName     | empFaceVOList   | String   | 部门名称        |
| - parentId     | empFaceVOList   | Long   | 上级部门 根部门上级为“-1”        |
| - parentDepartmentName     | empFaceVOList   | String   | 上级部门名称        |
| - isDefault     | empFaceVOList   | Byte   | 是否是默认部门（0不是默认部门1是默认部门）        |
| - empBaseList     | empFaceVOList   | List   | 上级部门名称        |
| -- empId     | empBaseList   | Long   | 员工id        |
| -- firstName     | empBaseList   | String   | 名        |
| -- lastName     | empBaseList   | String   | 姓        |
| -- empName     | empBaseList   | String   | 员工全名称        |
| -- empNo     | empBaseList   | String   | 员工编号        |
| positionVOS          | body   | List   | 职称信息        |
| - positionId     | positionVOS   | Long   | 员工职位ID        |
| - positionName     | positionVOS   | String   | 员工职位名称        |
| groupVO          | body   | List   | 人员分组信息        |
| - groupId     | groupVO   | Long   | 人员分组ID        |
| - groupName     | groupVO   | Long   | 人员分组名称        |

  ```json
  {
  "success": true,
  "code": "1000_SUS",
  "msg": "successful operation!",
  "data": {
    "empId": 311,
    "firstName": "shen",
    "lastName": "feima",
    "empNo": "1111",
    "empName": null,
    "departmentDetailVOS": null,
    "mail": "fff@uniubi.com",
    "mobile": null,
    "gender": 1,
    "genderText": "男",
    "empPhotoUrls": null,
    "empFaceVOList": [],
    "entryTime": null,
    "telNumber": null,
    "positionVOS": null,
    "typeVO": null,
    "groupVO": {
      "groupId": 1,
      "groupName": "-未分组-"
    },
    "workPlace": null,
    "cardNo": null,
    "userPass": null,
    "personGuid": "10CA7FE2EB7143E3877C2211207AE92D",
    "reason": null,
    "admin": 0,
    "empPhoto": null
  }
}
  ```

### 5.5 删除员工

* sdkRequestKey : `deleteEmployee`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| empNo             | body   | String   | Y        | 员工编号                        |
| orgId             | body   | Long     | Y        | 企业id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: addEmployeeFace' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "orgId":1,
        "empNo":"1111"
}'
```


* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```

### 5.6 删除员工照片

* sdkRequestKey : `deleteEmployee`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| empNo             | body   | String   | Y        | 员工编号                        |
| orgId             | body   | Long     | Y        | 企业id        |
| empFaceId         | body   | Long     | Y        | 员工照片id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: addEmployeeFace' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "orgId": 1,
        "empNo": "1111",
        "empFaceId": 5
}'
```


* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```


## 6 访客服务相关API

###65.1 添加访客信息

* sdkRequestKey : `addVisitor`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| visitorName         | body   | String   | Y        | 访客姓名                            |
| orgId               | body   | Long     | Y        | 企业id        |
| mail                | body   | String   | N        | 邮箱                           |
| phone               | body   | String   | N        | 手机号                          |
| gender              | body   | Byte     | N        | 性别 1:男 2:女                  |
| employeeInfoJson    | body   | String   | N        | 被访人信息，json字符串              |
| visitorNum          | body   | Integer     | N        | 来访人数             |
| companyName         | body   | String   | N        | 公司名称              |
| visitorPlateNum     | body   | String   | N        | 车牌号              |
| remark    | body    | String   | N        | 备注              |
| cardNo    | body    | String   | N        | 卡号              |
| visStartTime        | body   | date     | N        | 预约开始时间 yyyy-MM-dd HH:mm:ss            |
| visEndTime          | body   | date     | N        | 预约结束时间 yyyy-MM-dd HH:mm:ss            |
| facePermission      | Byte   | String   | N        | 人员权限 刷脸权限 1：无权限；2：有权限        |
| idCardPermission    | Byte   | String   | N        | 人员权限 刷卡权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）        |
| faceAndCardPermission         | Byte   | String   | Y        | 人员权限 人卡合一权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）       |
| passwordPermission            | Byte   | String   | Y        | 人员权限 密码开门 1：无权限；2：有权限        |
| originStr           | body   | String     | N        | 来访事由        |
| source              | body   | Byte     | N        | 预约登记来源0：web来访登记，1：二维码登记（不填默认web来访登记）        |
| sdkRequestKey       | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion   | header | String   | Y        | v2                         |
| sdkAccessToken      | header | String   | Y        | sdkAccessToken             |
| Content-Type        | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: addVisitor' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
          "visitorName":"feima2",
          "phone":"13388888888",
          "orgId":14,
          "gender":1,
          "mail":"fff@uniubi.com",
          "employeeInfoJson":"[{\"empId\":1,\"empNo\":\"001\",\"name\":\"犀婴 \"},{{\"empId\":2,\"empNo\":\"10065\",\"name\":\"卡卡西 \"}]",
          "visStartTime": "2023-08-14 10:27:28",
          "visEndTime": "2023-08-15 10:27:46",
          "facePermission": 1,
          "idCardPermission": 1,
          "faceAndCardPermission": 1
          }'
```


* 响应参数说明

| 字段名称          | 位置   | 字段类型 | 说明                       |
    | ----------------- | ------ | -------- | -------------------------- |
| recordId                | body   | Long     | 访问记录id                            |
| orgName         | body   | String   | 公司名称                            |

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": {
            "recordId": 1,
            "orgName": "公司名称"
      }
  }
  ```

### 6.2 添加访客照片

* sdkRequestKey : `addVisitorFace`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| photoBase64       | body   | String   | Y        | 用户照片base64位编码字符                            |
| recordId          | body   | Long     | Y        | 访问记录id                        |
| orgId             | body   | Long     | Y        | 企业id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: addVisitorFace' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "photoBase64":"....",
        "orgId":1,
        "recordId": 311
}'
```


* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```


### 6.3 编辑修改员工信息

* sdkRequestKey : `editVisitor`

* 请求参数说明

| 字段名称                | 位置   | 字段类型 | 是否必须 | 说明                       |
| ----------------------| ------ | -------- | -------- | -------------------------- |
| recordId              | body   | Long     | Y        | 访问记录id                            |
| orgId                 | body   | String   | Y        | 被访人公司id                            |
| visitorName           | body   | String   | Y        | 访客姓名                            |
| mail                  | body   | String   | N        | 邮箱                           |
| phone                 | body   | String   | N        | 手机号                          |
| gender                | body   | Byte     | N        | 性别 1:男 2:女                  |
| employeeInfoJson      | body   | String   | N        | 被访人信息，json字符串              |
| visitorNum            | body   | Integer     | N        | 来访人数             |
| companyName           | body   | String   | N        | 公司名称              |
| visitorPlateNum       | body   | String   | N        | 车牌号              |
| remark                | body    | String   | N        | 备注              |
| cardNo                | body    | String   | N        | 卡号              |
| visStartTime          | body   | date     | N        | 预约开始时间 yyyy-MM-dd HH:mm:ss            |
| visEndTime            | body   | date     | N        | 预约结束时间 yyyy-MM-dd HH:mm:ss            |
| facePermission        | Byte   | String   | N        | 人员权限 刷脸权限 1：无权限；2：有权限        |
| idCardPermission      | Byte   | String   | N        | 人员权限 刷卡权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）        |
| faceAndCardPermission         | Byte   | String   | Y        | 人员权限 人卡合一权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）       |
| passwordPermission            | Byte   | String   | Y        | 人员权限 密码开门 1：无权限；2：有权限        |
| originStr             | body   | String     | N        | 来访事由        |
| source                | body   | Byte     | N        | 预约登记来源0：web来访登记，1：二维码登记（不填默认web来访登记）        |
| sdkRequestKey         | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion     | header | String   | Y        | v2                         |
| sdkAccessToken        | header | String   | Y        | sdkAccessToken             |
| Content-Type          | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: editVisitor' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
          "recordId":1,
          "visitorName":"feima2",
          "phone":"13388888888",
          "orgId":14,
          "gender":1,
          "mail":"fff@uniubi.com",
          "employeeInfoJson":"[{\"empId\":1,\"empNo\":\"001\",\"name\":\"犀婴 \"},{{\"empId\":2,\"empNo\":\"10065\",\"name\":\"卡卡西 \"}]",
          "visStartTime": "2023-08-14 10:27:28",
          "visEndTime": "2023-08-15 10:27:46",
          "facePermission": 1,
          "idCardPermission": 1,
          "faceAndCardPermission": 1
}'
```


* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```


### 5.4 查询访客信息

* sdkRequestKey : `queryVisitorInfo`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| recordId          | body   | Long     | Y        | 访问记录id                        |
| orgId             | body   | Long     | Y        | 企业id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: queryVisitorInfo' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "recordId":1,
        "orgId": 1
}'
```


* 响应参数说明

| 字段名称                | 位置   | 字段类型 | 是否必须 | 说明                       |
| ----------------------| ------ | -------- | -------- | -------------------------- |
| recordId              | body   | Long     | Y        | 访问记录id                            |
| orgId                 | body   | String   | Y        | 被访人公司id                            |
| visitorName           | body   | String   | Y        | 访客姓名                            |
| mail                  | body   | String   | N        | 邮箱                           |
| phone                 | body   | String   | N        | 手机号                          |
| gender                | body   | Byte     | N        | 性别 1:男 2:女                  |
| employeeInfoJson      | body   | String   | N        | 被访人信息，json字符串              |
| visStatus             | body   | Byte     | N        | 访客状态 0未到访 1 访问中 2 已结束 3 已过期             |
| visStatusText         | body   | Byte     | N        | 访客状态描述             |
| visitorNum            | body   | Integer     | N        | 来访人数             |
| companyName           | body   | String   | N        | 公司名称              |
| visitorPlateNum       | body   | String   | N        | 车牌号              |
| remark                | body    | String   | N        | 备注              |
| cardNo                | body    | String   | N        | 卡号              |
| visStartTime          | body   | date     | N        | 预约开始时间 yyyy-MM-dd HH:mm:ss            |
| visEndTime            | body   | date     | N        | 预约结束时间 yyyy-MM-dd HH:mm:ss            |
| facePermission        | Byte   | String   | N        | 人员权限 刷脸权限 1：无权限；2：有权限        |
| idCardPermission      | Byte   | String   | N        | 人员权限 刷卡权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）        |
| faceAndCardPermission         | Byte   | String   | Y        | 人员权限 人卡合一权限 1：无权限；2：有权限 （刷卡权限和人卡合一不可同时选中）       |
| passwordPermission            | Byte   | String   | Y        | 人员权限 密码开门 1：无权限；2：有权限        |
| originStr             | body   | String     | N        | 来访事由        |
| visitFaceVOS        | body   | List     | N        | 来访人照片信息集合        |
| - visitorFaceId     | visitFaceVOS   | Long   | 来访人注册照id        |
| - faceUrl           | visitFaceVOS   | String   | 来访人人脸照片URL        |
| - cardNo            | visitFaceVOS   | Long   | 访客卡号        |
| - recordId          | visitFaceVOS   | Long   | 访问记录id        |
| - orgName           | visitFaceVOS   | Long   | 公司名称        |

* 响应示例

 ```json
  {
  "success": true,
  "code": "1000_SUS",
  "msg": "successful operation!",
  "data": {
    "recordId": 58,
    "visitFaceVOS": [],
    "visitorName": "feima2",
    "phone": "13388888888",
    "mail": "fff@uniubi.com",
    "employeeInfoJson": "[{\"firstName\":\"shen\",\"lastName\":\"feima\",\"orgId\":1,\"gender\":1,\"empNo\":1111,\"mail\":\"feima@uniubi.com\"}]",
    "visStatus": 0,
    "visStatusText": "未到访",
    "visStartTime": "2023-08-14T10:27:28",
    "visEndTime": "2023-08-15T10:27:46",
    "signInTime": null,
    "signOutTime": null,
    "visitorNum": null,
    "companyName": null,
    "visitorPlateNum": null,
    "gender": 1,
    "remark": null,
    "cardNo": null,
    "facePermission": 1,
    "idCardPermission": 1,
    "faceAndCardPermission": 1,
    "idCardFacePermission": 1,
    "passwordPermission": 1,
    "originStr": null,
    "deviceAuthVOS": [],
    "source": 0
  }
}
  ```
 
 
### 5.5 删除访客

* sdkRequestKey : `deleteVisitor`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| recordId          | body   | Long     | Y        | 访问记录id                        |
| orgId             | body   | Long     | Y        | 企业id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: queryVisitorInfo' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "recordId":1,
        "orgId": 1
}'
```


* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```

### 5.6 删除访客照片

* sdkRequestKey : `deleteVisitorFace`

* 请求参数说明

| 字段名称          | 位置   | 字段类型 | 是否必须 | 说明                       |
    | ----------------- | ------ | -------- | -------- | -------------------------- |
| recordId          | body   | Long     | Y        | 访问记录id                        |
| orgId             | body   | Long     | Y        | 企业id        |
| visitorFaceId         | body   | Long     | Y        | 访客照片id        |
| sdkRequestKey     | header | String   | Y        | sdkRequestKey 放在请求头中 |
| requestKeyVersion | header | String   | Y        | v2                         |
| sdkAccessToken    | header | String   | Y        | sdkAccessToken             |
| Content-Type      | header | String   | Y        | application/json           |

* 请求示例

```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: addEmployeeFace' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data '{
        "recordId": 1,
        "orgId": 1,
        "visitorFaceId": 5
}'
```

* 响应参数说明

* 响应示例

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": null
  }
  ```