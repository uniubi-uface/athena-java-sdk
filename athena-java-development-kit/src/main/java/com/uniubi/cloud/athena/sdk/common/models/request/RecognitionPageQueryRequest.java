package com.uniubi.cloud.athena.sdk.common.models.request;

import com.uniubi.cloud.athena.sdk.common.models.SdkBasePageRequest;

import java.util.List;

/**
 * 识别记录查询对象
 * @author jingmu
 */
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

    public Byte getPersonType() {
        return personType;
    }

    public void setPersonType(Byte personType) {
        this.personType = personType;
    }

    public Long getStartTimeMillis() {
        return startTimeMillis;
    }

    public void setStartTimeMillis(Long startTimeMillis) {
        this.startTimeMillis = startTimeMillis;
    }

    public Long getEndTimeMillis() {
        return endTimeMillis;
    }

    public void setEndTimeMillis(Long endTimeMillis) {
        this.endTimeMillis = endTimeMillis;
    }

    public String getDeviceSearch() {
        return deviceSearch;
    }

    public void setDeviceSearch(String deviceSearch) {
        this.deviceSearch = deviceSearch;
    }

    public String getPersonSearch() {
        return personSearch;
    }

    public void setPersonSearch(String personSearch) {
        this.personSearch = personSearch;
    }

    public List<Long> getPersonIdList() {
        return personIdList;
    }

    public void setPersonIdList(List<Long> personIdList) {
        this.personIdList = personIdList;
    }

    public List<Long> getDepIds() {
        return depIds;
    }

    public void setDepIds(List<Long> depIds) {
        this.depIds = depIds;
    }

    @Override
    public String toString() {
        return "RecognitionPageQueryRequest{" + "personType=" + personType + ", startTimeMillis=" + startTimeMillis
            + ", endTimeMillis=" + endTimeMillis + ", deviceSearch='" + deviceSearch + '\'' + ", personSearch='"
            + personSearch + '\'' + ", personIdList=" + personIdList + ", depIds=" + depIds + '}';
    }

}