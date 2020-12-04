package com.bsoft.anthony.springbootservice.controller;

import com.bsoft.anthony.springbootservice.domain.DoctorDomain;
import com.bsoft.anthony.springbootservice.pojo.ListDoctorPojo;
import com.bsoft.anthony.springbootservice.response.ResponseEntity;
import com.bsoft.anthony.springbootservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "appointment")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	// @ApiOperation(value = "医生信息获取")
	@RequestMapping(value = "/listDoctor",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<List<DoctorDomain>> selectList(@Valid @RequestBody ListDoctorPojo listDoctorPojo) throws ParseException {
		List<DoctorDomain> doctor = doctorService.selectList(listDoctorPojo.getOrganizationId(),listDoctorPojo.getDepartmentId(),listDoctorPojo.getScheduleDate(),listDoctorPojo.getDoctorId(),listDoctorPojo.getDoctorType(),listDoctorPojo.getOutpatientType(),listDoctorPojo.getLastModifyTime(),listDoctorPojo.getPageNo(),listDoctorPojo.getPageSize());
			ResponseEntity<List<DoctorDomain>> entity=new ResponseEntity<>();
			
			entity.setData(doctor);
			return entity;
	}
}
