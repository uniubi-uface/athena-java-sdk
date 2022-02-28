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
 * @author 井木
 * @since 2021/10/20
 */
public interface SdkAtdReportApi {

    /**
     * 考勤明细报表查询
     * @param queryRequest 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "atdDetailReport", version = "v1", desc = "考勤明细报表查询")
    SdkResult<SdkPageInfo<AtdDetailReportResponseModel>> atdDetailReport(AtdReportQueryRequest queryRequest);

    /**
     * 考勤加班报表
     * @param queryRequest 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "atdOverWorkReport", version = "v1", desc = "考勤加班报表")
    SdkResult<SdkPageInfo<AtdOverWorkReportResponseModel>> atdOverWorkReport(AtdReportQueryRequest queryRequest);

    /**
     * 考勤休息报表
     * @param queryRequest 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "atdBreakTimeReport", version = "v1", desc = "考勤休息报表")
    SdkResult<SdkPageInfo<AtdBreakTimeReportResponseModel>> atdBreakTimeReport(AtdReportQueryRequest queryRequest);

    /**
     * 考勤异常打卡报表
     * @param queryRequest 请求参数
     * @return 报表数据
     */
    @RequestMark(name = "atdExceptionReport", version = "v1", desc = "考勤异常打卡报表")
    SdkResult<SdkPageInfo<AtdExceptionReportResponseModel>> atdExceptionReport(AtdReportQueryRequest queryRequest);

}
