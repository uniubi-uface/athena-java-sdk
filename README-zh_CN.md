## athena-java-sdk

[English Document](./README.md)

### 版本发布日志

* [版本发布日志中文文档](/docs/ReleaseNotes-zh_CN.md)

### 开放API文档

* [UStarCloud Open API 中文文档](./docs/UStar%20Cloud%20open%20API-zh_CN.md)

  Open API 提供了 http/https 接口，开发者可通过Open API对接UStarCloud，

  获取考勤相数据、设备识别记录数据等。根据产品roadmap，后续会提供更多 API 能力。

### Athena Java SDK 示例

通过Open API，开发者可以使用各种语言对接UStarCloud获取相应的数据，如java、C、c++等。

为了方便对接，我们提供了Java SDK，实现Open API 的对接。并提供以下SDK的使用示例：

* [简单示例](./athena-sdk-examples/api-simple-example)
* [Spring Boot 示例](./athena-sdk-examples/api-springboot-example)
* [消息接收示例](./athena-sdk-examples/message-receive-example)

### Maven 依赖

Maven依赖GAV:

```xml

<dependency>
    <groupId>com.uniubi.cloud</groupId>
    <artifactId>athena-java-development-kit</artifactId>
    <version>${latestTagName}</version>
</dependency>
```

请使用最新的RELEASE tag名称作为版本号