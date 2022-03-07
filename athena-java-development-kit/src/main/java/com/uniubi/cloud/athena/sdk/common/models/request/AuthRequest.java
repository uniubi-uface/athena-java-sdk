package com.uniubi.cloud.athena.sdk.common.models.request;

/**
 * 鉴权请求对象
 *
 * @author jingmu
 * @since 2020/3/26
 */
public class AuthRequest {

    private String accessKey;

    private String accessSecret;

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

    @Override
    public String toString() {
        return "AuthRequest{" + "accessKey='" + accessKey + '\'' + ", accessSecret='" + accessSecret + '\'' + '}';
    }

}
