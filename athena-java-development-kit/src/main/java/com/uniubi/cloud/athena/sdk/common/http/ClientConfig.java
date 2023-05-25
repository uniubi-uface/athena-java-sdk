package com.uniubi.cloud.athena.sdk.common.http;

/**
 * 请求配置
 * @author jingmu
 * @since 2020/3/31
 */
public class ClientConfig {

    private Long connectionTimeoutMills;

    private Long readTimeoutMills;

    private Long writeTimeoutMills;

    public Long getConnectionTimeoutMills() {
        return connectionTimeoutMills;
    }

    public void setConnectionTimeoutMills(Long connectionTimeoutMills) {
        this.connectionTimeoutMills = connectionTimeoutMills;
    }

    public Long getReadTimeoutMills() {
        return readTimeoutMills;
    }

    public void setReadTimeoutMills(Long readTimeoutMills) {
        this.readTimeoutMills = readTimeoutMills;
    }

    public Long getWriteTimeoutMills() {
        return writeTimeoutMills;
    }

    public void setWriteTimeoutMills(Long writeTimeoutMills) {
        this.writeTimeoutMills = writeTimeoutMills;
    }

    @Override
    public String toString() {
        return "ClientConfig{" + "connectionTimeoutMills=" + connectionTimeoutMills + ", readTimeoutMills="
            + readTimeoutMills + ", writeTimeoutMills=" + writeTimeoutMills + '}';
    }

}
