package com.uniubi.cloud.athena.sdk.auth;

import com.uniubi.cloud.athena.sdk.common.SdkLang;
import com.uniubi.cloud.athena.sdk.common.TokenLoader;
import com.uniubi.cloud.athena.sdk.common.constant.DeveloperConstants;
import com.uniubi.cloud.athena.sdk.common.exception.UniUbiAresSDKException;
import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;
import com.uniubi.cloud.athena.sdk.common.models.request.AuthRequest;
import com.uniubi.cloud.athena.sdk.common.models.response.AuthResponseModel;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 抽象tokenLoader实现
 *
 * @author jingmu
 * @since 2020/4/2
 */
public abstract class AbstractTokenLoader implements TokenLoader {

    private final UniUbiHttpClient uniUbiHttpClient;

    private final String accessKey;

    private final String accessSecret;

    private final String requestUrl;

    private final SdkLang sdkLang;

    public AbstractTokenLoader(UniUbiHttpClient uniUbiHttpClient, String accessKey, String accessSecret,
            String requestUrl, SdkLang sdkLang) {
        this.uniUbiHttpClient = uniUbiHttpClient;
        this.accessKey = accessKey;
        this.accessSecret = accessSecret;
        this.requestUrl = requestUrl;
        this.sdkLang = sdkLang;
    }

    /**
     * 从服务器中获取token
     * @return 返回sdkToken
     */
    protected String requestForToken() {
        AuthRequest authRequest = getAuthRequest();
        // 鉴权获取token
        AuthResponseModel authResponseModel;
        try {
            // 鉴权请求不经过加密处理
            Map<String, String> authHeader = getAuthHeader();
            authResponseModel = uniUbiHttpClient.sendPostRequest(requestUrl, authRequest, authHeader,
                    AuthResponseModel.class);
        }
        catch (Exception e) {
            throw new UniUbiAresSDKException(e);
        }
        if (authResponseModel.isSuccess()) {
            return authResponseModel.getData();
        }
        else {
            throw new UniUbiAresSDKException(MessageFormat.format("load accessToken failed with : {0}({1})",
                    authResponseModel.getMsg(), authResponseModel.getCode()));
        }
    }

    protected Map<String, String> getAuthHeader() {
        Map<String, String> header = new HashMap<>(2);
        header.put(DeveloperConstants.HEADER_REQUEST_KEY_NAME, DeveloperConstants.AUTH_REQUEST_KEY);
        header.put(DeveloperConstants.HEADER_REQUEST_KEY_VERSION, DeveloperConstants.DEFAULT_REQUEST_KEY_VERSION);
        header.put(DeveloperConstants.HEADER_LANG_NAME, sdkLang.getValue());
        return header;
    }

    private AuthRequest getAuthRequest() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAccessKey(accessKey);
        authRequest.setAccessSecret(accessSecret);
        return authRequest;
    }

}
