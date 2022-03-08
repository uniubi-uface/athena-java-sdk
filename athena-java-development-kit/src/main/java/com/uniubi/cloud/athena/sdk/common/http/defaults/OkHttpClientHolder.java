package com.uniubi.cloud.athena.sdk.common.http.defaults;

import com.uniubi.cloud.athena.sdk.common.http.ClientConfig;
import okhttp3.OkHttpClient;

import java.time.Duration;

/**
 * Okhttp 客户端单例
 *
 * @author 井木
 * @since 2022/03/08
 */
public final class OkHttpClientHolder {

    private static OkHttpClient instance;

    public static OkHttpClient getInstance(ClientConfig clientConfig) {
        if (instance == null) {
            synchronized (OkHttpClientHolder.class) {
                if (instance == null) {
                    if (clientConfig != null) {
                        instance = new OkHttpClient.Builder()
                                .connectTimeout(Duration.ofMillis(clientConfig.getConnectionTimeoutMills()))
                                .writeTimeout(Duration.ofMillis(clientConfig.getWriteTimeoutMills()))
                                .readTimeout(Duration.ofMillis(clientConfig.getReadTimeoutMills())).build();
                    }
                    else {
                        instance = new OkHttpClient.Builder().build();
                    }
                }
            }
        }
        return instance;
    }

}
