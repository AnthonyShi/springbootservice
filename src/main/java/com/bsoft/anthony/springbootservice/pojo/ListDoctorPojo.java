package com.bsoft.anthony.springbootservice.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ListDoctorPojo implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull(message = "医院代码不能为空")
    private String  organizationId;
    // @NotNull(message = "科室代码不能为空")
    private String departmentId;
    private String scheduleDate;
    private String doctorId;
    private String doctorType;
    private int outpatientType;
    private String lastModifyTime;
    @NotNull
    private Integer pageNo;
    @NotNull
    private Integer pageSize;

}