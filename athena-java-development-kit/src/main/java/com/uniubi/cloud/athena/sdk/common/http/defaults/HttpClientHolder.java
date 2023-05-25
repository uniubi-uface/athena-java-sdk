package com.uniubi.cloud.athena.sdk.common.http.defaults;

import com.uniubi.cloud.athena.sdk.common.http.ClientConfig;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * Okhttp 客户端单例
 * @author 井木
 * @since 2022/03/08
 */
public final class HttpClientHolder {

    /**
     * http连接池对象
     */
    private static PoolingHttpClientConnectionManager cm;

    private static RequestConfig requestConfig;

    /**
     * 初始化连接池
     */
    public static void init(ClientConfig clientConfig) {
        if (cm == null) {
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory()).build();

            cm = new PoolingHttpClientConnectionManager(registry);
            // 最多同时连接20个请求
            cm.setMaxTotal(20);
            // 每个路由最大连接数，路由指 IP+PORT 或者域名
            cm.setDefaultMaxPerRoute(50);
        }
        if (requestConfig == null) {
            // 设置请求参数配置，创建连接时间、从连接池获取连接时间、数据传输时间、是否测试连接可用、构建配置对象
            requestConfig = RequestConfig.custom()
                // 服务器返回数据(response)的时间，超过该时间抛出read timeout
                .setSocketTimeout(clientConfig.getReadTimeoutMills().intValue())
                // 连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
                .setConnectTimeout(clientConfig.getConnectionTimeoutMills().intValue())
                // 从连接池中获取连接的超时时间，超过该时间未拿到可用连接，
                // 会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout
                // waiting for connection from pool
                .setConnectionRequestTimeout(clientConfig.getConnectionTimeoutMills().intValue()).build();
        }
    }

    /**
     * 从连接池中获取httpClient连接
     */
    public static HttpClient getHttpClient() {
        // 创建httpClient时从连接池中获取，并设置连接失败时自动重试（也可以自定义重试策略：setRetryHandler()）
        return HttpClients.custom().setDefaultRequestConfig(requestConfig).setConnectionManager(cm)
            .disableAutomaticRetries().build();
    }

}
