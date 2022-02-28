package com.uniubi.cloud.athena.sdk.springboot.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * athena config properties
 *
 * @author 井木
 * @since 2022/02/24
 */
@ConfigurationProperties(prefix = "athena.sdk")
public class AthenaSdkConfigProperties {

    /**
     * public key
     */
    private String publicKey;

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * accessSecret
     */
    private String accessSecret;

    /**
     * connection timeout mills
     */
    private Long connectionTimeoutMills = 3000L;

    /**
     * read timeout mills
     */
    private Long readTimeoutMills = 3000L;

    /**
     * write timeout mills
     */
    private Long writeTimeoutMills = 3000L;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

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
        return "AthenaSdkConfigProperties{" + "publicKey='" + publicKey + '\'' + ", accessKey='" + accessKey + '\''
                + ", accessSecret='" + accessSecret + '\'' + ", connectionTimeoutMills=" + connectionTimeoutMills
                + ", readTimeoutMills=" + readTimeoutMills + ", writeTimeoutMills=" + writeTimeoutMills + '}';
    }

}
