package com.uniubi.cloud.athena.sdk.clients;

import com.uniubi.cloud.athena.sdk.common.annotation.RequestMark;
import com.uniubi.cloud.athena.sdk.common.models.SdkPageInfo;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;
import com.uniubi.cloud.athena.sdk.common.models.request.AtdReportQueryRequest;
import com.uniubi.cloud.athena.sdk.common.models.request.EmployeeFaceAddRequest;
import com.uniubi.cloud.athena.sdk.common.models.request.EmployeeFaceDeleteRequest;
import com.uniubi.cloud.athena.sdk.common.models.request.EmployeeQueryRequest;
import com.uniubi.cloud.athena.sdk.common.models.request.EmployeeRegisterRequest;
import com.uniubi.cloud.athena.sdk.common.models.response.AtdExceptionReportResponseModel;
import com.uniubi.cloud.athena.sdk.common.models.response.EmployeeInfoResponse;

/**
 * 员工相关API
 * @author feima
 * @since 2023-08-21
 */
public interface SdkEmployeeApi {

    /**
     * 员工注册
     * <p>
     * register employee
     * @param request 请求参数
     */
    @RequestMark(name = "registerEmployee", version = "v2", desc = "员工注册")
    SdkResult<Void> registerEmployee(EmployeeRegisterRequest request);

    /**
     * 添加员工照片
     * <p>
     * add employee face photo
     * @param request 请求参数
     */
    @RequestMark(name = "addEmployeeFace", version = "v2", desc = "添加员工照片")
    SdkResult<Void> addEmployeeFace(EmployeeFaceAddRequest request);

    /**
     * 查询员工信息
     * <p>
     * query employee info
     * @param request 请求参数
     */
    @RequestMark(name = "queryEmployeeInfo", version = "v2", desc = "查询员工信息")
    SdkResult<EmployeeInfoResponse> queryEmployeeInfo(EmployeeQueryRequest request);

    /**
     * 员工信息编辑
     * <p>
     * edit employee
     * @param request 请求参数
     */
    @RequestMark(name = "editEmployee", version = "v2", desc = "员工信息编辑修改")
    SdkResult<Void> editEmployee(EmployeeRegisterRequest request);

    /**
     * 删除员工
     * <p>
     * delete employee
     * @param request 请求参数
     */
    @RequestMark(name = "deleteEmployee", version = "v2", desc = "删除员工")
    SdkResult<Void> deleteEmployee(EmployeeQueryRequest request);

    /**
     * 删除员工照片
     * <p>
     * delete employee face photo
     * @param request 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "deleteEmployeeFace", version = "v2", desc = "删除员工照片")
    SdkResult<Void> deleteEmployeeFace(EmployeeFaceDeleteRequest request);

}
