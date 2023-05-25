package com.uniubi.cloud.athena.sdk.common.constant;

/**
 * sdk常量
 * @author jingmu
 * @since 2020/3/26
 */
public class DeveloperConstants {

    /**
     * 宇泛sdk统一请求地址
     */
    public static final String ATHENA_SDK_UNIFY_URL = "/develop/sdk/unify/v2";

    /**
     * 鉴权 requestKey
     */
    public static final String AUTH_REQUEST_KEY = "authToken";

    /**
     * 校验token requestKey
     */
    public static final String AUTH_VALIDATE_REQUEST_KEY = "validateToken";

    /**
     * 请求头 requestKey 的 名称
     */
    public static final String HEADER_REQUEST_KEY_NAME = "sdkRequestKey";

    /**
     * 请求头 requestKey版本的名称
     */
    public static final String HEADER_REQUEST_KEY_VERSION = "requestKeyVersion";

    /**
     * 请求头 accessToken的名称
     */
    public static final String HEADER_ACCESS_TOKEN_NAME = "sdkAccessToken";

    /**
     * 请求头 语言名称
     */
    public static final String HEADER_LANG_NAME = "lang";

    /**
     * 默认版本常量
     */
    public static final String DEFAULT_REQUEST_KEY_VERSION = "v2";

    /**
     * token校验失败返回码
     */
    public static final String TOKEN_FAILED_CODE = "ATHENA-SDK-008";

    /**
     * http请求成功code
     */
    public static final int HTTP_OK_CODE = 200;

}
