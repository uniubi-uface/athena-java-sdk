package com.uniubi.cloud.athena.sdk.common.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * com.uniubi.medusa.ares.develop.models.SdkPageInfo
 *
 * @author jingmu
 * @date 2020/5/7
 */
@Data
@Accessors(chain = true)
public class SdkPageInfo<T> {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 页数
     */
    private Integer pages;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据集合
     */
    private List<T> list;

}
