package com.uniubi.cloud.athena.sdk.common;

import com.uniubi.cloud.athena.sdk.common.http.UniUbiHttpClient;

/**
 * 请求配置 用来配置okHttp请求的超时时间 用户可以在创建 UniUbiSDKClient 对象时传入，最终会交给 UniUbiHttpClient 对http请求完成配置
 * @author jingmu
 * @see UniUbiHttpClient 宇泛http请求实现
 * @since 2020/3/26
 */
public class RequestConfig {

    /**
     * endPoint
     */
    private String endPoint = "https://www.ustar-cloud.com/api";

    @Deprecated
    private String publicKey;

    private Long connectionTimeoutMills = 3000L;

    private Long readTimeoutMills = 3000L;

    private Long writeTimeoutMills = 3000L;

    private TokenLoader tokenLoader;

    private RpcMethodInterceptor rpcMethodInterceptor;

    private SdkLang sdkLang = SdkLang.CN;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Long getConnectionTimeoutMills() {
        return connectionTimeoutMills;
    }

    public void setConnectionTimeoutMills(Long connectionTimeoutMills) {
        this.connectionTimeoutMills = connectionTimeoutMills;
    }

    public Long getReadTimeoutMills() {
        return readTimeoutMills;
    }

    public void setReadTimeoutMills(Long readTimeoutMills) {
        this.readTimeoutMills = readTimeoutMills;
    }

    public Long getWriteTimeoutMills() {
        return writeTimeoutMills;
    }

    public void setWriteTimeoutMills(Long writeTimeoutMills) {
        this.writeTimeoutMills = writeTimeoutMills;
    }

    public TokenLoader getTokenLoader() {
        return tokenLoader;
    }

    public void setTokenLoader(TokenLoader tokenLoader) {
        this.tokenLoader = tokenLoader;
    }

    public RpcMethodInterceptor getRpcMethodInterceptor() {
        return rpcMethodInterceptor;
    }

    public void setRpcMethodInterceptor(RpcMethodInterceptor rpcMethodInterceptor) {
        this.rpcMethodInterceptor = rpcMethodInterceptor;
    }

    public SdkLang getSdkLang() {
        return sdkLang;
    }

    public void setSdkLang(SdkLang sdkLang) {
        this.sdkLang = sdkLang;
    }

    @Override
    public String toString() {
        return "RequestConfig{" + "endPoint='" + endPoint + '\'' + ", publicKey='" + publicKey + '\''
            + ", connectionTimeoutMills=" + connectionTimeoutMills + ", readTimeoutMills=" + readTimeoutMills
            + ", writeTimeoutMills=" + writeTimeoutMills + ", tokenLoader=" + tokenLoader
            + ", rpcMethodInterceptor=" + rpcMethodInterceptor + ", sdkLang=" + sdkLang + '}';
    }

}
