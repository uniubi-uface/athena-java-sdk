

# API

## 1 Auth API

### 1.1 get sdkAccessToken

* sdkRequestKey : `authToken`

* request data desc

  | Filed             | Location | Type   | Required | Desc                                        |
    | ----------------- | -------- | ------ | -------- | ------------------------------------------- |
  | accessKey         | body     | String | true     | get from developer web page                 |
  | nonce             | body     | String | true     | 随机数                                      |
  | encrypted         | body     | String | true     | MD5(accessSecret+nonce )                    |
  | sdkRequestKey     | header   | String | true     | sdkRequestKey ,please put in request header |
  | requestKeyVersion | header   | String | true     | v2                                          |
  | Content-Type      | header   | String | true     | application/json                            |

* request example

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
* response

  | Filed   | Type    | Desc                                            |
    | :------ | :------ | :---------------------------------------------- |
  | code    | String  | 1000_SUS means ok                               |
  | success | boolean | true or false                                   |
  | msg     | String  | `successful operation!`  or `operation failed!` |
  | data    | String  | sdkAccessToken, expired 24 hours                |

* responseDesc

  ```json
{
"success": true,
"code": "1000_SUS",
"msg": "successful operation!",
"data": "d3b86512301c456ca96a90c4be1eccf4"
}
  ```




### 1.2 Test API

* sdkRequestKey : `test`

* request data desc：

  | Filed             | Location | Type   | Required | Desc                                           |
  | ----------------- | -------- | ------ | -------- | ---------------------------------------------- |
  | sdkRequestKey     | header   | String | true     | sdkRequestKey  please put it in request header |
  | requestKeyVersion | header   | String | true     | v2                                             |
| sdkAccessToken    | header   | String | true     | sdkAccessToken                                 |
  | Content-Type      | header   | String | true     | application/json                               |
  |                   | body     | String |          |                                                |
  
* request example

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: test' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: d3b86512301c456ca96a90c4be1eccf4' \
  --header 'Content-Type: application/json' \
  --data 'My name is Bright'
  ```

* responseDesc：

  ```json
  {
      "success": true,
      "code": "1000_SUS",
      "msg": "successful operation!",
      "data": "Hey boy, welcome to UStar Cloud developer platform! The data you input is My name is Bright"
  }
  ```



## 2 Attendance API

### 2.1 atdDetailReport

* sdkRequestKey : `atdDetailReport`

* request data desc

  | Filed             | Location | Type    | Required | Desc                                           |
    | ----------------- | -------- | ------- | -------- | ---------------------------------------------- |
  | pageNum           | body     | Integer | Y        |                                                |
  | pageSize          | body     | Integer | Y        |                                                |
  | deptId            | body     | String  | N        | department id                                  |
  | empName           | body     | String  | N        | emp name                                       |
  | startDate         | body     | date    | N        | yyyy-MM-dd                                     |
  | endDate           | body     | date    | N        | yyyy-MM-dd                                     |
  | sdkRequestKey     | header   | String  | true     | sdkRequestKey  please put it in request header |
  | requestKeyVersion | header   | String  | true     | v2                                             |
  | sdkAccessToken    | header   | String  | true     | sdkAccessToken                                 |
  | Content-Type      | header   | String  | true     | application/json                               |

* request example

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: atdDetailReport' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: {{accessToken}}' \
  --header 'Content-Type: application/json' \
  --data '{
      "pageSize": 1,
      "pageNum": 1
  }'
  ```



* responseDesc

  | Filed                  | Type         | Desc                                                         |
    | ---------------------- | ------------ | ------------------------------------------------------------ |
  | personId               | String       | emp id                                                       |
  | personNo               | String       | emp no                                                     |
  | name                   | String       | emp name                                                     |
  | depNames               | String array | dept names                                                |
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

* request data desc

  | Filed | Location | Type | Required | Desc              |
    | --------- | -------- | -------- | ------------------- | ------------------- |
  | pageNum   | body | Integer  | Y        | 页码                |
  | pageSize  | body | Integer  | Y        | 每页限制条数        |
  | deptId    | body | String   | N        | 部门id              |
  | empName   | body | String   | N        | 员工名称/编号       |
  | startDate | body | date     | N        | 开始日期 yyyy-MM-dd |
  | endDate   | body | date     | N        | 结束日期 yyyy-MM-dd |
  | sdkRequestKey     | header | String   | true     | sdkRequestKey  please put it in request header |
  | requestKeyVersion | header | String   | true     | v2                         |
  | sdkAccessToken    | header | String   | true     | sdkAccessToken             |
  | Content-Type      | header | String   | true     | application/json           |
* request example

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: atdOverWorkReport' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: {{accessToken}}' \
  --header 'Content-Type: application/json' \
  --data '{
      "pageSize": 2,
      "pageNum": 1
  }'
  ```



* responseDesc

  | Filed                 | Type         | Desc                                                         |
    | --------------------- | ------------ | ------------------------------------------------------------ |
  | personId              | String       | emp id                                                       |
  | personNo              | String       | emp no                                                     |
  | name                  | String       | emp name                                                     |
  | depNames              | String array | dept names                                                |
  | roleNames             | String array | role names                                                |
  | atDate                | date         | yyyy-MM-dd                                              |
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

* request data desc

  | Filed | Location | Type | Required | Desc              |
    | --------- | ---- | -------- | -------- | ------------------- |
  | pageNum   | body | Integer  | Y        | 页码                |
  | pageSize  | body | Integer  | Y        | 每页限制条数        |
  | deptId    | body | String   | N        | 部门id              |
  | empName   | body | String   | N        | 员工名称/编号       |
  | startDate | body | date     | N        | 开始日期 yyyy-MM-dd |
  | endDate   | body | date     | N        | 结束日期 yyyy-MM-dd |
  | sdkRequestKey     | header | String   | true     | sdkRequestKey  please put it in request header |
  | requestKeyVersion | header | String   | true     | v2                         |
  | sdkAccessToken    | header | String   | true     | sdkAccessToken             |
  | Content-Type      | header | String   | true     | application/json           |

* request example

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: atdBreakTimeReport' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: xxxxxxxx' \
  --header 'Content-Type: application/json' \
  --data '{
      "pageSize": 1,
      "pageNum": 1
  }'
  ```



* responseDesc

  | Filed                 | Type         | Desc                               |
    | --------------------- | ------------ | ---------------------------------- |
  | personId              | String       | emp id                             |
  | personNo              | String       | emp no                           |
  | name                  | String       | emp name                           |
  | depNames              | String array | dept names                      |
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

* request data desc

  | Filed     | Location | Type    | Required | Desc                |
    | --------- | -------- | ------- | -------- | ------------------- |
  | pageNum   | body     | Integer | Y        | 页码                |
  | pageSize  | body     | Integer | Y        | 每页限制条数        |
  | deptId    | body     | String  | N        | 部门id              |
  | empName   | body     | String  | N        | 员工名称/编号       |
  | startDate | body     | date    | N        | 开始日期 yyyy-MM-dd |
  | endDate   | body     | date    | N        | 结束日期 yyyy-MM-dd |

* request example

  ```shell
  curl --location 'https://www.ustar-cloud.com/api/develop/sdk/unify/v2' \
  --header 'sdkRequestKey: atdExceptionReport' \
  --header 'requestKeyVersion: v2' \
  --header 'sdkAccessToken: {{accessToken}}' \
  --header 'Content-Type: application/json' \
  --data '{
      "pageSize": 2,
      "pageNum": 1
  }'
  ```

* responseDesc

  | Filed      | Type     | Desc                       |
    | --------------- | ------------ | ---------------------------- |
  | personId        | String       | emp id                       |
  | personNo        | String       | emp no                     |
  | name            | String       | emp name                     |
  | depNames        | String array | dept names                |
  | roleNames       | String array | 职位名称集合                 |
  | atDate          | date         | 日期 yyyy-MM-dd              |
  | recognitionTime | Date         | 打卡时间 yyyy-MM-dd HH:mm:ss |
  | clockPhotoId    | String       | 卡图片Id                     |
  | deviceKey       | String       | 设备key                      |
  | deviceName      | String       | 设备名称                     |
  | sdkRequestKey     | header | String   |
  | requestKeyVersion | header | String   |
  | sdkAccessToken    | header | String   |
  | Content-Type      | header | String   |

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

## 事件消息结构Desc

* 请求方法：`POST`

* 请求类型：`application/json`

* 请求体内容：

  | Filed   | Type   | Desc                                   |
    | ------- | ------ | -------------------------------------- |
  | msgId   | String | 消息id                                 |
  | type    | number | 消息类型 详细请参考数据字典[3.4](#3.4) |
  | content | String | 消息内容为事件回调内容的json 字符串    |

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

  | Filed              | Type         | Desc                                                         |
    | ------------------ | ------------ | ------------------------------------------------------------ |
  | id                 | number       | 识别记录id                                                   |
  | orgId              | number       | 公司id                                                       |
  | personType         | number       | 识别记录类型<br />1:员工;<br />2:访客;<br />3:陌生人         |
  | deviceKey          | String       | 识别设备序列号                                               |
  | deviceName         | String       | 设备名称                                                     |
  | personId           | Long         | emp id或者访客id                                             |
  | empNo              | String       | 人员编号                                                     |
  | departmentNames    | string array | 所属部门名称（用于员工）                                     |
  | name               | String       | emp name                                                     |
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