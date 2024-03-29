package com.uniubi.cloud.athena.sdk.clients;

import com.uniubi.cloud.athena.sdk.common.annotation.RequestMark;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;

/**
 * 测试api
 * <p>
 * The test API
 * @author jingmu
 * @since 2020/5/8
 */
public interface SdkTestApi {

    /**
     * 测试接口
     * <p>
     * test api
     * @return the test api result is string。
     */
    @RequestMark(name = "test", version = "v2", desc = "测试接口")
    SdkResult<String> test(Object input);

}
