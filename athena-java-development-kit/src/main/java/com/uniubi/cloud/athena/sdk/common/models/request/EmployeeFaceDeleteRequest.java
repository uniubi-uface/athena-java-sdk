package com.uniubi.cloud.athena.sdk.common.models.request;


/**
 * 员工照片删除请求实体类
 * @author FeiMa
 */
public class EmployeeFaceDeleteRequest extends EmployeeQueryRequest {

    /**
     * 员工照片id
     */
    private Long empFaceId;

    public Long getEmpFaceId() {
        return empFaceId;
    }

    public void setEmpFaceId(Long empFaceId) {
        this.empFaceId = empFaceId;
    }
}
