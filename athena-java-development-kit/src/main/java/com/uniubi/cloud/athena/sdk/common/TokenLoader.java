package com.uniubi.cloud.athena.sdk.common;

/**
 * token加载器 用来实现获取 SDKToken 逻辑 loadToken方法在 UniUbiSdkClientProxyFactory
 * 中调用用来每次sdk方法请求时将凭证放入请求头部
 * @author jingmu
 * @see UniUbiSdkClientProxyFactory sdk客户端代理工厂，创建sdk客户端实例对象的工厂
 * @since 2020/3/26
 */
public interface TokenLoader {

    /**
     * 获取token
     * @return 返回token
     */
    String loadToken();

    /**
     * 刷新token
     */
    void refreshToken();

}
