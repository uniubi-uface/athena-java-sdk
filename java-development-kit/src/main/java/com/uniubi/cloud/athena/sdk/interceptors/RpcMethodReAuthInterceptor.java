package com.uniubi.cloud.athena.sdk.interceptors;

import com.uniubi.cloud.athena.sdk.common.RpcMethod;
import com.uniubi.cloud.athena.sdk.common.RpcMethodInterceptor;
import com.uniubi.cloud.athena.sdk.common.constant.DeveloperConstants;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;

/**
 * 远程方法拦截器：重新授权 该拦截器作用就是当拦截到返回结果是token无效时，会进行一次重新授权（刷新token），再重试调用操
 * 该拦截器设计是与SimpleTokenLoader搭配，防止服务端token丢失导致sdk调用失败
 *
 * @author jingmu
 * @date 2020/5/7
 */
public class RpcMethodReAuthInterceptor implements RpcMethodInterceptor {

    @Override
    public Object process(RpcMethod rpcMethod) {
        // 直接尝试调用
        Object result = rpcMethod.invoke();
        if (result instanceof SdkResult) {
            SdkResult sdkResult = (SdkResult) result;
            if (!sdkResult.isSuccess()) {
                // 如果调用结果是失败的，并且错误原因是token过期
                if (DeveloperConstants.TOKEN_FAILED_CODE.equals(sdkResult.getCode())) {
                    // 刷新token
                    rpcMethod.getTokenLoader().refreshToken();
                    // 重试调用
                    return rpcMethod.invoke();
                }
            }
        }
        return result;
    }

}
