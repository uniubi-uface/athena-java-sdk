package com.uniubi.cloud.athena.sdk.common.models;

/**
 * com.uniubi.medusa.ares.develop.models.SdkBasePageRequest
 *
 * @author jingmu
 * @since 2020/5/15
 */
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SdkBasePageRequest{" + "pageNum=" + pageNum + ", pageSize=" + pageSize + '}';
    }

}
