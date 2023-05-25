package com.uniubi.cloud.athena.sdk.auth;

import com.uniubi.cloud.athena.sdk.common.SdkLang;
import com.uniubi.cloud.athena.sdk.common.TokenLoader;
import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;

/**
 * token加载器默认实现 请求服务器获取token之后每12小时刷新一次
 * @author jingmu
 * @since 2020/3/26
 */
public class SimpleTokenLoader extends AbstractTokenLoader implements TokenLoader {

    private final Object LOCK_OBJ;

    private volatile String accessToken;

    public SimpleTokenLoader(UniUbiHttpClient uniUbiHttpClient, String requestUrl, String accessKey,
                             String accessSecret, SdkLang sdkLang) {
        super(uniUbiHttpClient, accessKey, accessSecret, requestUrl, sdkLang);
        LOCK_OBJ = new Object();
    }

    @Override
    public String loadToken() {
        if (accessToken == null) {
            synchronized (LOCK_OBJ) {
                if (accessToken == null) {
                    accessToken = requestForToken();
                }
            }
        }
        return accessToken;
    }

    @Override
    public void refreshToken() {
        synchronized (LOCK_OBJ) {
            accessToken = requestForToken();
        }
    }

}
