package com.bsoft.anthony.springbootservice.dao.sys;

import com.bsoft.anthony.springbootservice.pojo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:17:10 2020/11/30
 * @Modified By:
 */
@Mapper
public interface SysUserRoleMapper {
    List<SysUserRole> listByUserId(Integer userId);
}
