package com.bsoft.anthony.springbootservice.service;

import com.bsoft.anthony.springbootservice.dao.his.DoctorMapper;
import com.bsoft.anthony.springbootservice.domain.DoctorDomain;
import com.bsoft.anthony.springbootservice.utils.DateUtil;
import com.bsoft.anthony.springbootservice.utils.RedisUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DoctorService {
	@Autowired
	DoctorMapper doctorMapper;
	@Resource
	private RedisUtil redisUtil;

	// @Cacheable(cacheNames = "doctorList")
	public List<DoctorDomain> selectList(String hospitalCode, String departmentCode, String scheduleDate, String doctorCode, String doctorType, int outpatientType, String lastModifyTime,int pageNo,int pageSize) throws ParseException {
		List<DoctorDomain> doctor = new ArrayList<>();
		// if(redisUtil.get("deprtmentCode"+departmentCode)!=null){
		// 	doctor.add((DoctorDomain)redisUtil.get(departmentCode));
		// 	return doctor;
		// }


		// if(redisUtil.hget("departmentCode"+hospitalCode,departmentCode)!=null){
		// 	doctor.add((DoctorDomain)redisUtil.hget("departmentCode"+hospitalCode,departmentCode));
		// 	return doctor;
		// }
		if (pageNo==0) {
			pageNo = 1;
		}
		if (pageSize==0) {
			pageSize = 10;
		}
		Date startdate = null;
		Date enddate = null;
		Date now = null;
		Date yestday = null;
		int isnullDate = 0;
		int ghrq;
		now = new Date();
		yestday = DateUtil.addDateToDay(now,-1);
		if(scheduleDate!=null&&!"".equals(scheduleDate)){
			
			isnullDate = 1;
			SimpleDateFormat strat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				startdate = strat.parse(scheduleDate+" 00:00:00");
				enddate = strat.parse(scheduleDate+" 23:59:59");
			} catch (ParseException e) {
				e.printStackTrace();
				throw new ParseException("转换错误",1);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ghrq = DateUtil.getDayofweek(sdf.parse(scheduleDate));
		}else {
			ghrq = DateUtil.getDayofweek(now);
		}
		PageHelper.startPage(pageNo, pageSize);
		doctor = doctorMapper.selectList(hospitalCode, departmentCode,isnullDate, startdate, enddate,yestday,doctorCode,doctorType, outpatientType,ghrq);
		for(DoctorDomain doctorDomain:doctor){
			// redisUtil.set("deprtmentCode"+doctorDomain.getDepartmentId(),doctorDomain);
			// redisUtil.hset("departmentCode"+hospitalCode,doctorDomain.getDepartmentId(),doctorDomain);
		}
		return doctor;
		
	}

}
