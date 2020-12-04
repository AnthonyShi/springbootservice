package com.bsoft.anthony.springbootservice.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class DoctorDomain implements Serializable {
	private String organizationId;
	private String departmentId;
	private String departmentName;
	private String doctorId;
	private String doctorName;
	private String doctorSex;
	private String doctorInformation;
	private String doctorGoodAt;
	private String doctorJob;
	private String majorQualify;
	private String regFee;
	private String workRankId;
	private String keyWord;
	private String flag;
	private String ygjb;


}
