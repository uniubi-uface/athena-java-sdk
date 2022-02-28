package com.uniubi.cloud.athena.sdk.springboot.example.demo;

import com.alibaba.fastjson.JSON;
import com.uniubi.cloud.athena.sdk.clients.SdkTestApi;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * api demo
 *
 * @author 井木
 * @since 2022/02/24
 */
@Component
public class ApiDemo implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    SdkTestApi sdkTestApi;

    /**
     * just call for demo
     * @param event spring event
     */
    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        SdkResult<String> testResult = sdkTestApi.test();
        System.out.println(JSON.toJSONString(testResult));
    }

}
