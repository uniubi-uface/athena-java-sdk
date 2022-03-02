package com.uniubi.cloud.athena.sdk.common.models.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.cloud.athena.sdk.common.models.SdkBasePageRequest;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author 井木
 * @since 2021/10/20
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AtdReportQueryRequest extends SdkBasePageRequest {

    /**
     * 部门id
     * <p>
     * department ID.
     */
    private String deptId;

    /**
     * 员工名称/编号
     * <p>
     * search key ,employee name or employee NO.
     */
    private String empName;

    /**
     * 开始日期 格式：yyyy-MM-dd
     * <p>
     * start date,format:yyyy-MM-dd
     */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate startDate;

    /**
     * 结束日期 yyyy-MM-dd
     * <p>
     * end date,format:yyyy-MM-dd
     */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate endDate;

}
