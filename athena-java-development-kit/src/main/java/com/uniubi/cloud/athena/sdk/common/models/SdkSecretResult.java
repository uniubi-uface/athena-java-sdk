package com.uniubi.cloud.athena.sdk.common.models;

/**
 * com.uniubi.medusa.ares.develop.common.models.SdkSecretResult
 * @author jingmu
 * @since 2020/6/17
 */
public class SdkSecretResult {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回code码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回结果数据
     */
    private String data;

    /**
     * 加密口令
     */
    private String secret;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "SdkSecretResult{" + "success=" + success + ", code='" + code + '\'' + ", msg='" + msg + '\''
            + ", data='" + data + '\'' + ", secret='" + secret + '\'' + '}';
    }

}
