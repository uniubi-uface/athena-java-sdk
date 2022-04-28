<div style="text-align: center; font-size: 36px; font-weight: bold">UStar Cloud SDK 接口文档</div>

<br/><br/>

# 0 修订记录

> 接口文档版本与UStarCloud的版本号对应

| SDK版本 | 修改时间 | 修改人 | 修改内容                                                     |
| ------- | -------- | ------ | ------------------------------------------------------------ |
| 2.3.0 | 2021-11-22 | 井木   | 1.新增 |

<br/><br/>

# 1 请求说明

## 1.1 请求地址

**统一路径: `https://www.ustar-cloud.com/api/develop/sdk`**

* 请求方法为`POST`
* 请求头：`Content-Type: application/json;charset=UTF-8`

| 字段名称            | 位置   | 类型   | 是否必须 | 说明                                                         |
| ------------------- | ------ | ------ | -------- | ------------------------------------------------------------ |
| sdkRequestKey     | header | String | Y        | 请求KEY                                                      |
| requestKeyVersion | header | String | Y        | 请求接口的版本，默认为`v1`                                               |
| sdkAccessToken    | header | String | Y        | 从服务端获取的token                                          |
| sdkSecretKey      | header | String | Y        | AES KEY经过[RSA publicKey](#2)加密后的密文                   |
| lang                | header | String | Y        | 语言种类，具体请看[字典3.1](#3.1)                            |
| requestData         | body   | String | Y        | requestData分为加密和不加密两种，具体请参考[requestData说明](#requestData) |

* `sdkAccessToken`: 有效期为1天，失效后可重新获取

* `AES KEY`: AES KEY由开发者自己生成，每次请求key建议不同，生成规则参见[2.2](#2.2)

## 1.2 requestData说明<a id="requestData"></a>

### 1.2.1 加密接口

接口的参数作为json对象requestData的值，即

```json
   {
      "requestData": {
      "pageSize": 10,
      "empNo": "58693",
      "pageNum": 1
      }
   }
```

再将上述json字符串进行AES加密后的密文作为请求body

 ```
 PK0AgL+Ws/TCzw2/PPzPhJnCgXqwb0ZddQ4o+EDGDhXhibTj2KXEqF2CXRKZ8OOgqZuktd1uvEHA
 0VBz9I8iZw==
 ```

Postman中request body 示例
![Postman body img1](./img/image1.png)

### 1.2.2 不加密接口

不加密接口：直接将接口参数作为json对象requestData的值

```json
  {
    "requestData": {
      "accessKey": "1dc8908e728b445d91c4d133ef40c92a",
      "accessSecret": "09555323806d4e809eee1617082ea6b1"
    }
  }
```
上述json字符串作为请求body

Postman中request body 示例

![Postman body img2](./img/image2.png)

# 2 密钥<a id="2"></a>

> 管理员在UStarCloud开发者接入平台页面，创建一个新的开发者平台
> 系统会自动为该新平台生成` accessKey `和 `accessSecret`，还有数据加解密用的 `publicKey`
> 其中`accessKey`和`accessSecret`用于权限认证生成`sdkAccessToken`

## 2.1 RSA

RSA的公钥和私钥由UStarCloud生成，在UStarCloud的对接平台页面获取RSA公钥。公钥用来加解密AES key

## 2.2 AES<a id="2.2"></a>

* AES key 由开发者自己生成，使用`128 bit` 即`16 byte`
* 偏移量`iv` 从`AES key`中获取，规则为：第一步将`AES key`反转（倒序）后取前`16`位

# 3 数据字典

> 各字典数据包括但不限于以下字典项

## 3.1 语言<a id ="3.1"></a>

| 字典项 | 字典值 | 值类型 | 说明     |
| ------ | ------ | ------ | -------- |
| 中文   | zh_CN  | String | 简体中文 |
| 英文   | en     | String | English  |

## 3.2 性别<a id ="3.2"></a>

| 字典项 | 字典值 | 值类型 | 说明   |
| ------ | ------ | ------ | ------ |
| 未填写 | 0      | number | 未填写 |
| 男     | 1      | number | 男     |
| 女     | 2      | number | 女     |

## 3.3 员工权限类型<a id="3.3"></a>

| 字典项   | 字典值 | 值类型 | 说明     |
| -------- | ------ | ------ | -------- |
| 人像识别 | 1      | number | 人像识别 |
| 刷卡识别 | 2      | number | 刷卡识别 |
| 人卡合一 | 3      | number | 人卡合一 |
| 人证比对 | 4      | number | 人证比对 |

## 3.4 事件类型<a id="3.4"></a>

| 字典项       | 字典值 | 值类型 | 说明         |
| ------------ | ------ | ------ | ------------ |
| 识别记录事件 | 1      | number | 识别记录事件 |
| 员工添加事件 | 2      | number | 员工添加事件 |
| 员工更新事件 | 3      | number | 员工更新事件 |
| 员工删除事件 | 4      | number | 员工删除事件 |
| 部门添加事件 | 5      | number | 部门添加事件 |
| 部门更新事件 | 6      | number | 部门更新事件 |
| 部门删除事件 | 7      | number | 部门删除事件 |

> 注意：暂只支持识别记录事件

## 3.5 考勤日期类型<a id="3.5"></a>

| 字典项             | 字典值 | 值类型 | 说明               |
| ------------------ | ------ | ------ | ------------------ |
| 工作日(普通时间段) | 1      | number | 工作日(普通时间段) |
| 工作日(弹性时间段) | 2      | number | 工作日(弹性时间段) |
| 休息日             | 3      | number | 休息日             |
| 节假日             | 4      | number | 节假日             |
| 未排班             | 5      | number | 未排班             |

## 3.6 设备状态<a id="3.6"></a>

| 字典项       | 字典值 | 值类型 | 说明         |
| ------------ | ------ | ------ | ------------ |
| 设备离线     | 0      | number | 设备离线     |
| 设备在线     | 1      | number | 设备在线     |
| 设备禁用     | 2      | number | 设备禁用     |
| 设备密码错误 | 3      | number | 设备密码错误 |

# 4 SDK接口

## 4.1 接口响应说明

> ResponseHeader中`Content-Type: application/json;charset=UTF-8`

### 4.1.1 统一结果返回字段<a id="4.1.1"></a>

| 字段名称 | 参数类型 | 说明                                             |
| :------- | :------- | :----------------------------------------------- |
| code     | String   | 返回参数的code，`1000_SUS`表示成功，其他表示失败 |
| success  | boolean  | `true`表示成功，`false`表示失败                  |
| msg      | String   | `successful operation!`  or `operation failed!`  |
| data     | Object   | 各请求返回的数据进行AES加密后的字符串            |
| secret   | String   | AES KEY进行RSA私钥加密后的密文(需使用公钥解密)   |

**注意：**

* **4.2中的接口如果无返回数据，实际接口的data字段则为null**
* **4.2中的接口如果字段名称为`无`，返回数据即为data字段的内容**

### 4.1.2 分页结果返回字段

> 以下字段作为公共响应字段中的data字段的数据

| 字段名称 | 参数类型        | 说明                                                         |
| -------- | --------------- | ------------------------------------------------------------ |
| pageNum  | number(integer) | 页码                                                         |
| pageSize | number(integer) | 分页数据数量                                                 |
| pages    | number(integer) | 总页数                                                       |
| total    | number(long)    | 总数据数量                                                   |
| list     | array(list)     | 数据集合 java list<br />分页查询的接口的数据实际为list的内容 |

## 4.2 测试接口

### 4.2.1 测试接口

* sdkRequestKey : `test`

* 请求参数说明：无请求参数

* 响应参数说明：

  | 字段名称 | 字段类型 | 说明                   |
  | -------- | -------- | ---------------------- |
  | 无       | String   | Hey boy, welcome to UStar Cloud! |

## 4.3 鉴权API

### 4.3.1 获取sdkAccessToken

* sdkRequestKey : `authToken`

* 请求参数说明

  | 字段名称     | 字段类型 | 是否必须 | 说明                   |
    | ------------ | -------- | -------- | ---------------------- |
  | accessKey    | String   | Y        | 开发者接入平台页面获取 |
  | accessSecret | String   | Y        | 开发者接入平台页面获取 |

  > 该请求无需进行body加密，即
   ```json
   {
       "requestData":{
           "accessKey":"1dc8908e728b445dxxxxxxxxx",
           "accessSecret":"09555323806d4exxxxxxxxxxxxxx"
       }
   }
   ```
* 响应参数说明

  | 字段名称 | 字段类型 | 说明                                                         |
    | -------- | -------- | ------------------------------------------------------------ |
  | 无       | String   | 返回的字符串为请求其他接口的凭证，放在request header中sdkAccessToken项 |

  > **注意：token未进行加密，有效期为1天**

## 4.4 考勤报表相关API

### 4.4.1 考勤明细报表

* sdkRequestKey : `atdDetailReport`

* 请求参数说明

  | 字段名称  | 字段类型 | 是否必须 | 说明                |
    | --------- | -------- | -------- | ------------------- |
  | pageNum   | Integer  | Y        | 页码                |
  | pageSize  | Integer  | Y        | 每页限制条数        |
  | deptId    | String   | N        | 部门id              |
  | empName   | String   | N        | 员工名称/编号       |
  | startDate | date     | N        | 开始日期 yyyy-MM-dd |
  | endDate   | date     | N        | 结束日期 yyyy-MM-dd |

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
  | dateType               | number       | 日期类型  字典数据[3.5](#3.5)                                |
  | signInStart            | Date         | 开始签到时间,当且仅当dateType=2时有值                        |
  | signInEnd              | Date         | 结束签到时间,当且仅当dateType=2时有值                        |

### 4.4.2 考勤明细报表

* sdkRequestKey : `atdOverWorkReport`

* 请求参数说明

  | 字段名称  | 字段类型 | 是否必须 | 说明                |
    | --------- | -------- | -------- | ------------------- |
  | pageNum   | Integer  | Y        | 页码                |
  | pageSize  | Integer  | Y        | 每页限制条数        |
  | deptId    | String   | N        | 部门id              |
  | empName   | String   | N        | 员工名称/编号       |
  | startDate | date     | N        | 开始日期 yyyy-MM-dd |
  | endDate   | date     | N        | 结束日期 yyyy-MM-dd |

* 响应参数说明

  | 字段名称              | 字段类型     | 说明                          |
    | --------------------- | ------------ | ----------------------------- |
  | personId              | String       | 人员id                        |
  | personNo              | String       | 员工编号                      |
  | name                  | String       | 人员姓名                      |
  | depNames              | String array | 部门名称集合                  |
  | roleNames             | String array | 职位名称集合                  |
  | atDate                | date         | 日期 yyyy-MM-dd               |
  | workDayOverWorkSecond | long number  | 工作日加班时长 单位秒         |
  | restDayOverWorkSecond | long number  | 休息日加班时长 单位秒         |
  | holidayOverWorkSecond | long number  | 节假日加班时长 单位秒         |
  | dateType              | number       | 日期类型  字典数据[3.5](#3.5) |

### 4.4.3 考勤休息报表

* sdkRequestKey : `atdBreakTimeReport`

* 请求参数说明

  | 字段名称  | 字段类型 | 是否必须 | 说明                |
    | --------- | -------- | -------- | ------------------- |
  | pageNum   | Integer  | Y        | 页码                |
  | pageSize  | Integer  | Y        | 每页限制条数        |
  | deptId    | String   | N        | 部门id              |
  | empName   | String   | N        | 员工名称/编号       |
  | startDate | date     | N        | 开始日期 yyyy-MM-dd |
  | endDate   | date     | N        | 结束日期 yyyy-MM-dd |

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

### 4.4.4 考勤异常打卡报表

* sdkRequestKey : `atdExceptionReport`

* 请求参数说明

  | 字段名称  | 字段类型 | 是否必须 | 说明                |
    | --------- | -------- | -------- | ------------------- |
  | pageNum   | Integer  | Y        | 页码                |
  | pageSize  | Integer  | Y        | 每页限制条数        |
  | deptId    | String   | N        | 部门id              |
  | empName   | String   | N        | 员工名称/编号       |
  | startDate | date     | N        | 开始日期 yyyy-MM-dd |
  | endDate   | date     | N        | 结束日期 yyyy-MM-dd |

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

# 5 事件订阅回调

> 管理员登录UStar客户端，在开发者对接平台页面，设置对接平台的回调地址和关注的事件
> UStar客户端系统内部会监测当这些事件发生时会向关注了这些事件的对接平台发送这些事件的消息
> 如果消息发送因为网络原因导致了失败，系统会重试发送，目前重试次数最大为20次，每次间隔5分钟

## 5.1 事件消息结构说明

* 请求方式：`POST`

* 请求类型：`application/json`

* 请求体内容：

  | 字段名称 | 字段类型 | 说明                                   |
  | -------- | -------- | -------------------------------------- |
  | msgId    | String   | 消息id                                 |
  | type     | number   | 消息类型 详细请参考数据字典[3.4](#3.4) |
  | content  | String   | 消息内容为事件回调内容的json 字符串    |

* 响应体内容：

  | 字段名称 | 字段类型 | 说明                                                         |
    | -------- | -------- | ------------------------------------------------------------ |
  | success  | boolean  | 是否接收成功<br />返回true，系统就不会再处理该消息<br />返回false，系统则会在5分钟后进行重试处理 |

> **注意1：响应数据要求以json格式返回**
>
> **注意2：处理系统回调消息时，只有正确返回了成功返回结果，才算这个消息处理成功，否则系统会一直重试**
>
> **注意3：消费端需要做好幂等性控制**
>
> **注意4：事件消息推送以HTTP的方式进行数据推送，请求中不包含权限和认证信息**

## 5.2 回调事件

### 5.2.1 识别记录回调事件

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
