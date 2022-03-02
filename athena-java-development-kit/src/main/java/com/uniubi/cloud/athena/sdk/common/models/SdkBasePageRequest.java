package com.uniubi.cloud.athena.sdk.common.models;

import lombok.Data;

/**
 * com.uniubi.medusa.ares.develop.models.SdkBasePageRequest
 *
 * @author jingmu
 * @since 2020/5/15
 */
@Data
public class SdkBasePageRequest {

    /**
     * 页码
     * <p>
     * page NO.
     */
    private Integer pageNum = 1;

    /**
     * 每页限制条数
     * <p>
     * page size.
     */
    private Integer pageSize = 10;

}
