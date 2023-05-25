package com.uniubi.cloud.athena.sdk.common.models;

/**
 * com.uniubi.medusa.ares.develop.common.models.MsgResult
 * @author jingmu
 * @since 2020/5/26
 */
public class MsgResult {

    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "MsgResult{" + "success=" + success + '}';
    }

}
