package com.uniubi.cloud.athena.sdk.common.models;

import lombok.Data;

/**
 * sdk统一返回结果对象
 *
 * @author jingmu
 * @since 2020/5/6
 */
@Data
public class SdkResult<T> {

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
    private T data;

}
