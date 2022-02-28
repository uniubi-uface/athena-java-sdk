package com.uniubi.cloud.athena.sdk.common.models.request;

import com.uniubi.cloud.athena.sdk.common.models.SdkBasePageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 识别记录查询对象
 *
 * @author jingmu
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RecognitionPageQueryRequest extends SdkBasePageRequest {

    /**
     * 识别记录类型 1.员工 2访客 3陌生人
     */
    private Byte personType;

    /**
     * 识别记录起始时间, UTC 毫秒
     */
    private Long startTimeMillis;

    /**
     * 识别记录结束时间, UTC 毫秒
     */
    private Long endTimeMillis;

    /**
     * 设备序列号/设备名称
     */
    private String deviceSearch;

    /**
     * 姓名/人员编号
     */
    private String personSearch;

    /**
     * 员工、访客模糊查询匹配到的人员ID
     */
    private List<Long> personIdList;

    private List<Long> depIds;

}