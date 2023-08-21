package com.uniubi.cloud.athena.sdk.common.models.request;

/**
 * 访客信息查询请求实体类
 * @author FeiMa
 */
public class VisitorQueryRequest {

    /**
     * 访客id
     */
    private Long recordId;
    /**
     * 企业信息
     */
    private Long orgId;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
