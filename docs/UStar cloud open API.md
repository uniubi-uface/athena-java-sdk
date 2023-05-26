# API

## 1 Auth API

### 1.1 get sdkAccessToken

* sdkRequestKey : `authToken`

* request data desc

| Filed             | Location | Type   | Required | Desc                                        |
    | ----------------- | -------- | ------ | -------- | ------------------------------------------- |
| accessKey         | body     | String | true     | get from developer web page                 |
| nonce             | body     | String | true     | random number                                      |
| encrypted         | body     | String | true     | MD5(accessSecret+nonce)                    |
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
| roleNames              | String array | role Names                                                 |
| atDate                 | date         | date yyyy-MM-dd                                              |
| timeIntervalName       | String       | Time period name                                                   |
| planSignInDatetime     | Date         | Expected check-in time yyyy-MM-dd HH:mm:ss                               |
| planSignOutDatetime    | Date         | Time for signing out yyyy-MM-dd HH:mm:ss                               |
| planTimeIntervalSecond | long number  | Planned working hours during the time period, in seconds                                  |
| realSignInTime         | Date         | Actual check-in time yyyy-MM-dd HH:mm:ss                             |
| signInStatus           | number       | Sign-in status<br />1:normal<br />2:Lack of cards<br />3:late<br />4:Early retirement<br />5:No clock in (missing card)<br />6:work overtime |
| realSignOutTime        | date         | Actual check-out time yyyy-MM-dd HH:mm:ss                             |
| signOutStatus          | number       | Sign out status<br />1:normal<br />2:Lack of cards<br />3:late<br />4:Early retirement<br />5:No clock in (missing card)<br />6:work overtime |
| realWorkTimeSecond     | long number  | Actual working hours in seconds                                          |
| normalWorkSecond       | long number  | Normal working hours in seconds                                         |
| realLateSecond         | long number  | Delay duration in seconds                                             |
| realLeaveEarlySecond   | long number  | Early leave duration in seconds                                              |
| realAbsenteeismSecond  | long number  | Absenteeism duration in seconds                                              |
| workDayOverWorkSecond  | long number  | Overtime duration on working days in seconds                                        |
| restDayOverWorkSecond  | long number  | Overtime duration on rest days in seconds                                        |
| holidayOverWorkSecond  | long number  | Overtime duration during holidays in seconds                                        |
| dateType               | number       | 1 working day (regular time period)<br />2 working days (flexible time period)<br />3 rest days<br />4 holidays<br />5 Unscheduled shifts<br /> |
| signInStart            | Date         | The start check-in time, which has a value only when date type=2                       |
| signInEnd              | Date         | End check-in time, with a value only when date type=2                        |

* response example

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

### 2.2 atdOverWorkReport

* sdkRequestKey : `atdOverWorkReport`

* request data desc

| Filed | Location | Type | Required | Desc              |
    | --------- | -------- | -------- | ------------------- | ------------------- |
| pageNum   | body | Integer  | Y        |                 |
| pageSize  | body | Integer  | Y        |         |
| deptId    | body | String   | N        | Department ID              |
| empName   | body | String   | N        | Employee Name        |
| startDate | body | date     | N        | yyyy-MM-dd |
| endDate   | body | date     | N        | yyyy-MM-dd |
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
| workDayOverWorkSecond | long number  | Overtime duration on working days in seconds                                        |
| restDayOverWorkSecond | long number  | Overtime duration on rest days in seconds                                        |
| holidayOverWorkSecond | long number  | Overtime duration during holidays in seconds                                        |
| dateType              | number       | 1 working day (regular time period)<br />2 working days (flexible time period)<br />3 rest days<br />4 holidays<br />5 Unscheduled shifts<br /> |

* response example

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

### 2.3 atdBreakTimeReport

* sdkRequestKey : `atdBreakTimeReport`

* request data desc

| Filed | Location | Type | Required | Desc              |
      | --------- | ---- | -------- | -------- | ------------------- |
| pageNum   | body | Integer  | Y        |                 |
| pageSize  | body | Integer  | Y        |         |
| deptId    | body | String   | N        | department id              |
| empName   | body | String   | N        | emp name       |
| startDate | body | date     | N        | yyyy-MM-dd |
| endDate   | body | date     | N        | yyyy-MM-dd |
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
| roleNames             | String array | role Names                       |
| atDate                | date         | attendance date yyyy-MM-dd                    |
| timeIntervalName      | String       | Time period name                         |
| breatimeName          | String       | The name of the break period for the time period               |
| planBreakTimeDuration | long number  | Planned rest duration in seconds               |
| realBreakTimeStart    | Date         | Actual start rest time yyyy-MM-dd        |
| realBreakTimeEnd      | Date         | Actual end rest time yyyy-MM-dd        |
| realBreakTimeDuration | long number  | Actual rest time in seconds               |
| breakStatus           | number       | Rest status: 0- unsettled, 1- normal, 2- abnormal |

* response example

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

### 2.4 atdExceptionReport

* sdkRequestKey : `atdExceptionReport`

* request data desc

  | Filed     | Location | Type    | Required | Desc                |
        | --------- | -------- | ------- | -------- | ------------------- |
  | pageNum   | body     | Integer | Y        |                 |
  | pageSize  | body     | Integer | Y        |         |
  | deptId    | body     | String  | N        | department id              |
  | empName   | body     | String  | N        | emp name       |
  | startDate | body     | date    | N        | yyyy-MM-dd |
  | endDate   | body     | date    | N        | yyyy-MM-dd |

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
  | roleNames       | String array | role Names                 |
  | atDate          | date         | yyyy-MM-dd              |
  | recognitionTime | Date         | check time yyyy-MM-dd HH:mm:ss |
  | clockPhotoId    | String       | photo id                     |
  | deviceKey       | String       | device SN                      |
  | deviceName      | String       | device Name                     |
  | sdkRequestKey     | header | String   |
  | requestKeyVersion | header | String   |
  | sdkAccessToken    | header | String   |
  | Content-Type      | header | String   |

* response example

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

# Event subscription callback

> The administrator logs in to the UStar client and sets the callback address and following events of the docking platform on the developer docking platform page. When these events occur, the UStar client system will internally monitor and send messages of these events to the docking platform that has followed them. If the message sending fails due to network reasons, the system will retry sending. Currently, the maximum number of retries is 20, with an interval of 5 minutes between each attempt

UStar Cloud will send HTTP requests to the addresses configured by various development platforms, using POST as the
request method.

## Event Message Structure Desc

* request method:`POST`

* content-type：`application/json`

* request body：

  | Filed   | Type   | Desc                                   |
      | ------- | ------ | -------------------------------------- |
  | msgId   | String | message id                                 |
  | type    | number | message type: 1 recognition |
  | content | String | JSON string with message content as event callback content    |

> Example of request body:
>
> ```json
> {
>     "msgId": "xxxxxxxx",
>     "type": 1,
>     "content": "{\"aliveType\":1,\"depNameConcat\":\"name1,name2\",\"departmentNames\":[\"name1\",\"name2\"],\"deviceKey\":\"84E0F42C3BB78702\",\"deviceName\":\"this is device name\",\"empNo\":\"001\",\"id\":3126713,\"name\":\"Joey T\",\"orgId\":97,\"passTimeType\":1,\"permissionTimeType\":1,\"personGuid\":null,\"personId\":8508,\"personType\":1,\"photoUrl\":\"https://uniubi-aiot.s3-eu-west-1.amazonaws.com/pkg365/2005/20050001000506/034000.411/img/ffe1fd7d-eecc-45c3-a6cf-14cee5c3361a.station\",\"recMode\":1,\"recStatus\":null,\"recType\":1,\"showTime\":\"2022-05-20 03:39:59\",\"temperature\":null,\"temperatureState\":null,\"temperatureUnit\":null,\"type\":1}"
> }
> ```

**For the convenience of docking, UStarCloud will determine whether to resend the request based on whether the HTTP
status code is 200 or not**

> HTTP status code=200 indicates that the development platform has successfully processed the message push, and UStarCloud will not retry.。
>
> HTTP status code != 200 indicates that the development platform failed to process the message, and UStarCloud will continue to retry.

## Callback Events

### Identify and record callback events

* Trigger condition: When the device recognition record is recalled to the system

* Event callback content:

  | Filed              | Type         | Desc                                                         |
      | ------------------ | ------------ | ------------------------------------------------------------ |
  | id                 | number       | recognition id                                                   |
  | orgId              | number       | organization id                                                       |
  | personType         | number       | Identify Record Types<br />1:emp;<br />2:visitor;<br />3:stranger         |
  | deviceKey          | String       | device Key                                               |
  | deviceName         | String       | device Name                                                     |
  | personId           | Long         | emp id or visitor id                                             |
  | empNo              | String       | emp no                                                     |
  | departmentNames    | string array | Department name (for employees)                                     |
  | name               | String       | emp name                                                     |
  | showTime           | Date         | Identification time：yyyy-MM-dd HH:mm:ss                          |
  | temperatureUnit    | number       | Body temperature unit <br />1: Degrees Celsius <br />2: Fahrenheit degree                     |
  | temperatureState   | number       | Body temperature status <br />1: Normal<br />2: Abnormal <br />3: Not set<br />4: Body temperature not measured (In the case of compatibility with null, null is also unmeasured or has no temperature measurement function)**** |
  | aliveBody          | number       | Living body judgment <br />1: Living body<br />2: Non living body<br />3: No live body assessment conducted |
  | permissionTimeType | number       | Effective time period judgment <br />1: Within the admission period<br />2: Not within the admission time<br />3: Failure to determine expiration date |
  | passTimeType       | number       | Effective date judgment <br />1: Within the validity period<br />2: Not within the validity period<br />3: Time period judgment not performed |
  | recMode            | number       | Recognition mode<br />1: Brush your face,<br />2: Swipe card,<br />3: Face&Card two-factor authentication<br />4: Witness comparison |
  | recStatus          | number       | Recognition pattern comparison results <br />1: Success <br />2: Failed                  |
  | recType            | number       | 1: Local identification<br />2 Cloud recognition                                    |
  | type               | number       | Identification results <br />1: Success;<br />2: Failed                           |
  | photoUrl           | String       | photo URL                                                    |