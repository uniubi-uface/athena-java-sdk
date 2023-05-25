package com.uniubi.cloud.athena.sdk.common.models;

import java.util.List;

/**
 * com.uniubi.medusa.ares.develop.models.SdkPageInfo
 * @author jingmu
 * @since 2020/5/7
 */
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

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SdkPageInfo{" + "pageNum=" + pageNum + ", pageSize=" + pageSize + ", pages=" + pages + ", total="
            + total + ", list=" + list + '}';
    }

}
