package com.uniubi.cloud.athena.sdk.common.models.request;

/**
 * 鉴权请求对象
 * @author jingmu
 * @since 2020/3/26
 */
public class AuthRequest {

    private String accessKey;

    private String encrypted;

    private String nonce;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "AuthRequest{" + "accessKey='" + accessKey + '\'' + ", encrypted='" + encrypted + '\'' + ", nonce='"
            + nonce + '\'' + '}';
    }

}
