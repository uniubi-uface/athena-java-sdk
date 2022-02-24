package com.uniubi.cloud.athena.sdk.common.models.request;

import lombok.Data;

/**
 * 鉴权请求对象
 *
 * @author jingmu
 * @date 2020/3/26
 */
@Data
public class AuthRequest {

    private String accessKey;

    private String accessSecret;

}
