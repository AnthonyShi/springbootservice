package com.bsoft.anthony.springbootservice.dao.his;

import com.bsoft.anthony.springbootservice.domain.DoctorDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface DoctorMapper {
    List<DoctorDomain> selectList(@Param("hospitalCode") String hospitalCode,
                                  @Param("departmentCode") String departmentCode,
                                  @Param("isnullDate") int isnullDate,
                                  @Param("startdate") Date startdate,
                                  @Param("enddate") Date enddate,
                                  @Param("now") Date now,
                                  @Param("doctorCode") String doctorCode,
                                  @Param("doctorType") String doctorType,
                                  @Param("outpatientType") int outpatientType,
                                  @Param("ghrq") int grq
    );
}
