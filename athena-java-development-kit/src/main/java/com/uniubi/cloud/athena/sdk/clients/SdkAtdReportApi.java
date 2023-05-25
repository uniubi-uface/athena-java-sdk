package com.uniubi.cloud.athena.sdk.clients;

import com.uniubi.cloud.athena.sdk.common.annotation.RequestMark;
import com.uniubi.cloud.athena.sdk.common.models.SdkPageInfo;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;
import com.uniubi.cloud.athena.sdk.common.models.request.AtdReportQueryRequest;
import com.uniubi.cloud.athena.sdk.common.models.response.AtdBreakTimeReportResponseModel;
import com.uniubi.cloud.athena.sdk.common.models.response.AtdDetailReportResponseModel;
import com.uniubi.cloud.athena.sdk.common.models.response.AtdExceptionReportResponseModel;
import com.uniubi.cloud.athena.sdk.common.models.response.AtdOverWorkReportResponseModel;

/**
 * 考勤相关 API， 提供考勤报表查询方法
 * <p>
 * The attendance related API provides the query method of attendance report
 * @author 井木
 * @since 2021/10/20
 */
public interface SdkAtdReportApi {

    /**
     * 考勤明细报表查询
     * <p>
     * Query of attendance details Report
     * @param queryRequest 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "atdDetailReport", version = "v2", desc = "考勤明细报表查询")
    SdkResult<SdkPageInfo<AtdDetailReportResponseModel>> atdDetailReport(AtdReportQueryRequest queryRequest);

    /**
     * 查询考勤加班报表
     * <p>
     * Query attendance overtime Report
     * @param queryRequest 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "atdOverWorkReport", version = "v2", desc = "考勤加班报表")
    SdkResult<SdkPageInfo<AtdOverWorkReportResponseModel>> atdOverWorkReport(AtdReportQueryRequest queryRequest);

    /**
     * 查询考勤休息报表
     *
     * Query attendance rest Report
     * @param queryRequest 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "atdBreakTimeReport", version = "v2", desc = "考勤休息报表")
    SdkResult<SdkPageInfo<AtdBreakTimeReportResponseModel>> atdBreakTimeReport(AtdReportQueryRequest queryRequest);

    /**
     * 查询考勤异常打卡报表
     * <p>
     * query abnormal clock list.
     * @param queryRequest 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "atdExceptionReport", version = "v2", desc = "考勤异常打卡报表")
    SdkResult<SdkPageInfo<AtdExceptionReportResponseModel>> atdExceptionReport(AtdReportQueryRequest queryRequest);

}
