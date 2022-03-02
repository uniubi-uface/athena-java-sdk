## athena-java-sdk

[中文文档](./README-zh_CN.md)

### Version Description

* [Version Release Notes](docs/ReleaseNotes.md)

### Open API Document

* [UStarCloud Open API Document](./docs/UStar%20cloud%20open%20API.md)

  Open API provides HTTP / HTTPS interfaces, and developers can connect to ustarcloud through open API,

  Obtain attendance phase data, equipment identification record data, etc. According to the product roadmap,

  more API capabilities will be provided later.

### Athena Java SDK Example

Through the open API, developers can use various languages to connect with UStarCloud to obtain corresponding data,

such as Java, C, C + +. In order to facilitate docking, we provide Java SDK to realize the docking of open API.

The following SDK usage examples are provided:

* [API simple example](./athena-sdk-examples/api-simple-example)
* [API springboot example](./athena-sdk-examples/api-springboot-example)
* [message receive example](./athena-sdk-examples/message-receive-example)

### Maven dependency

Maven dependency configuration:

```xml

<dependency>
    <groupId>com.uniubi.cloud</groupId>
    <artifactId>athena-java-development-kit</artifactId>
    <version>${latestTagName}</version>
</dependency>
```
Use the latest release tag name as the version.