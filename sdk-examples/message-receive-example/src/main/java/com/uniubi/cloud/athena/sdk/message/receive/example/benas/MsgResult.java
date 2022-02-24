package com.uniubi.cloud.athena.sdk.message.receive.example.benas;

/**
 * @author jingmu
 * @since 2021/06/04 17:59
 */
public class MsgResult {

    /**
     * 是否接收成功，返回true，系统就不会再处理该消息 * 返回false，系统则会在5分钟后进行重试处理
     */
    private Boolean success;

    public MsgResult(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
