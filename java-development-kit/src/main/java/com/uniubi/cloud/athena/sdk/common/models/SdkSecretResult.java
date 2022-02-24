package com.uniubi.cloud.athena.sdk.common.models;

import lombok.Data;

/**
 * com.uniubi.medusa.ares.develop.common.models.SdkSecretResult
 *
 * @author jingmu
 * @date 2020/6/17
 */
@Data
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

}
