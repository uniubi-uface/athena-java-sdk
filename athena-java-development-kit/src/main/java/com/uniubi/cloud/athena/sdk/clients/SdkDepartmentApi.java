package com.uniubi.cloud.athena.sdk.clients;

import com.uniubi.cloud.athena.sdk.common.annotation.RequestMark;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;
import com.uniubi.cloud.athena.sdk.common.models.response.DeptTreeVO;

/**
 * 部门相关api
 * @author FeiMa
 */
public interface SdkDepartmentApi {


    /**
     * 获取当前企业部门树信息
     * <p>
     * get org department tree info
     */
    @RequestMark(name = "getDepartTree", version = "v2", desc = "获取当前企业部门树信息")
    SdkResult<DeptTreeVO> getDepartTree();
}
