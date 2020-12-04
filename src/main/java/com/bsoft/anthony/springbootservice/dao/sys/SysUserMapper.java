package com.bsoft.anthony.springbootservice.dao.sys;

import com.bsoft.anthony.springbootservice.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:16:59 2020/11/30
 * @Modified By:
 */
@Mapper
public interface SysUserMapper {
    SysUser selectById(Integer id);
    SysUser selectByName(String name);
}
