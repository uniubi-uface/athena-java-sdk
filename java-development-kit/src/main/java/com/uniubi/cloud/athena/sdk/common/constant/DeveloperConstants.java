package com.uniubi.cloud.athena.sdk.common.constant;

import com.squareup.okhttp.MediaType;

import java.util.HashMap;
import java.util.Map;

/**
 * sdk常量
 *
 * @author jingmu
 * @date 2020/3/26
 */
public class DeveloperConstants {

    /**
     * 宇泛sdk统一请求地址
     */
    public static final String ATHENA_SDK_UNIFY_URL = "/develop/sdk/unify";

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
     * 请求头 aesKey的名称
     */
    public static final String HEADER_SECRET_KEY_NAME = "sdkSecretKey";

    /**
     * 请求头 语言名称
     */
    public static final String HEADER_LANG_NAME = "lang";

    /**
     * 默认版本常量
     */
    public static final String DEFAULT_REQUEST_KEY_VERSION = "v1";

    /**
     * 空请求体常量
     */
    public static final Map<String, String> EMPTY_PARAM;

    /**
     * token校验失败返回码
     */
    public static final String TOKEN_FAILED_CODE = "ATHENA-SDK-008";

    /**
     * sdk统一contentType
     */
    public static final MediaType SDK_UNIFY_CONTENT_TYPE = MediaType.parse("application/json");

    /**
     * 统一请求参数名称
     */
    public static final String REQUEST_DATA_KEY = "requestData";

    /**
     * http请求成功code
     */
    public static final int HTTP_OK_CODE = 200;

    /**
     * 国际化翻译的group
     */
    public static final String DEVELOP_I18N_GROUP = "SDK_I18N_GROUP";

    static {
        EMPTY_PARAM = new HashMap<>(8);
        EMPTY_PARAM.put(REQUEST_DATA_KEY, "{}");
    }

}
