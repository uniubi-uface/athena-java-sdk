package com.uniubi.cloud.athena.sdk.common.http.defaults;

import com.uniubi.cloud.athena.sdk.common.enums.CommonEnum;
import com.uniubi.cloud.athena.sdk.common.utils.UniUbiEnumUtils;

/**
 * 消息状态
 *
 * @author huanghuizhou ClassName Http error code enum.
 * @version V1.0.
 * @since 2020.07.10 09:51:53
 */
public enum HttpErrorCodeEnum implements CommonEnum<Integer> {

    /**
     * Code 0 http error code enum.
     */
    CODE_000(0, "未知异常"),

    /**
     * Code 400 http error code enum.
     */
    CODE_400(400, "回调请求错误"),

    /**
     * Code 401 http error code enum.
     */
    CODE_401(401, "回调请求身份验证失败"),

    /**
     * Code 402 http error code enum.
     */
    CODE_402(402, "回调异常"),

    /**
     * Code 403 http error code enum.
     */
    CODE_403(403, "拒绝执行"),

    /**
     * Code 404 http error code enum.
     */
    CODE_404(404, "回调地址不存在"),

    /**
     * Code 408 http error code enum.
     */
    CODE_408(408, "回调超时"),

    /**
     * Code 500 http error code enum.
     */
    CODE_500(500, "执行失败"),

    ;

    static {
        UniUbiEnumUtils.initEnum(HttpErrorCodeEnum.class);
    }

    private final Integer code;

    private final String desc;

    HttpErrorCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Gets by code.
     * @param code the code
     * @return the by code
     */
    public static HttpErrorCodeEnum getByCode(Integer code) {
        if (code == null) {
            return CODE_000;
        }
        return UniUbiEnumUtils.getByEnumCode(HttpErrorCodeEnum.class, code);
    }

    /**
     * Gets code.
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Gets desc.
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    @Override
    public Integer getEnumCode() {
        return code;
    }

}
