package com.uniubi.cloud.athena.sdk.springboot.example.config;

import com.uniubi.cloud.athena.sdk.clients.AthenaSdkApiClient;
import com.uniubi.cloud.athena.sdk.clients.SdkAtdReportApi;
import com.uniubi.cloud.athena.sdk.clients.SdkDeviceRecognitionApi;
import com.uniubi.cloud.athena.sdk.clients.SdkTestApi;
import com.uniubi.cloud.athena.sdk.common.RequestConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create api client bean
 *
 * @author 井木
 * @since 2022/02/24
 */
@EnableConfigurationProperties
@Configuration
public class AthenaSdkConfig {

    @Bean
    @ConditionalOnMissingBean(AthenaSdkApiClient.class)
    public AthenaSdkApiClient athenaSdkApiClient(AthenaSdkConfigProperties properties) {
        // 1. new RequestConfig
        RequestConfig requestConfig = new RequestConfig();
        // 2. set connection time out
        requestConfig.setConnectionTimeoutMills(properties.getConnectionTimeoutMills());
        requestConfig.setReadTimeoutMills(properties.getReadTimeoutMills());
        // 3. set your public key
        requestConfig.setPublicKey(properties.getPublicKey());
        // 4. set service end point if necessary
        requestConfig.setEndPoint("http://127.0.0.1:8080");
        // 5. create the AthenaSdkApiClient
        return new AthenaSdkApiClient(properties.getAccessKey(), properties.getAccessSecret(), requestConfig);
    }

    @Bean
    @ConditionalOnMissingBean(SdkTestApi.class)
    public SdkTestApi sdkTestApi(AthenaSdkApiClient apiClient) {
        return apiClient.createSdkTestApi();
    }

    @Bean
    @ConditionalOnMissingBean(SdkTestApi.class)
    public SdkDeviceRecognitionApi sdkDeviceRecognitionApi(AthenaSdkApiClient apiClient) {
        return apiClient.createSdkDeviceRecognitionApi();
    }

    @Bean
    @ConditionalOnMissingBean(SdkAtdReportApi.class)
    public SdkAtdReportApi sdkAtdReportApi(AthenaSdkApiClient apiClient) {
        return apiClient.createSdkAtdReportApi();
    }

}
