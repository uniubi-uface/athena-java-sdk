package com.uniubi.cloud.athena.sdk.clients;

import com.uniubi.cloud.athena.sdk.common.RequestConfig;
import com.uniubi.cloud.athena.sdk.common.UniUbiSdkClientProxyFactory;

/**
 * UStarCloud API 的客户端，动态代理创建API 客户端
 * <p>
 * UStarCloud API client, dynamic proxy creates API client
 *
 * @author jingmu
 * @since 2020/5/7
 */
public class AthenaSdkApiClient {

    private final UniUbiSdkClientProxyFactory uniUbiSDKClientProxyFactory;

    public AthenaSdkApiClient(String accessKey, String accessSecret) {
        this(accessKey, accessSecret, new RequestConfig());
    }

    public AthenaSdkApiClient(String accessKey, String accessSecret, RequestConfig requestConfig) {
        uniUbiSDKClientProxyFactory = new UniUbiSdkClientProxyFactory(accessKey, accessSecret, requestConfig);
    }

    /**
     * 测试用
     * @return 返回测试客户端接口
     */
    public SdkTestApi createSdkTestApi() {
        return uniUbiSDKClientProxyFactory.createProxy(SdkTestApi.class);
    }

    /**
     * 设备识别记录
     * @return 设备识别记录api
     */
    public SdkDeviceRecognitionApi createSdkDeviceRecognitionApi() {
        return uniUbiSDKClientProxyFactory.createProxy(SdkDeviceRecognitionApi.class);
    }

    /**
     * 考勤报表
     * @return SdkAtdReportApi
     */
    public SdkAtdReportApi createSdkAtdReportApi() {
        return uniUbiSDKClientProxyFactory.createProxy(SdkAtdReportApi.class);
    }

}
