package com.uniubi.cloud.athena.sdk.common;

import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;
import lombok.Data;

/**
 * 请求配置 用来配置okHttp请求的超时时间 用户可以在创建 UniUbiSDKClient 对象时传入，最终会交给 UniUbiHttpClient 对http请求完成配置
 *
 * @author jingmu
 * @date 2020/3/26
 * @see UniUbiHttpClient 宇泛http请求实现
 */
@Data
public class RequestConfig {

    /**
     * endPoint
     */
    private String endPoint = "https://www.ustar-cloud.com/api";

    private String publicKey;

    private Long connectionTimeoutMills = 3000L;

    private Long readTimeoutMills = 3000L;

    private Long writeTimeoutMills = 3000L;

    private TokenLoader tokenLoader;

    private RpcMethodInterceptor rpcMethodInterceptor;

    private SdkLang sdkLang = SdkLang.CN;

}
