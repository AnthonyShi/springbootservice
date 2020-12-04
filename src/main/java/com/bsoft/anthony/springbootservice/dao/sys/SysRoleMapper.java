package com.bsoft.anthony.springbootservice.dao.sys;

import com.bsoft.anthony.springbootservice.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:17:08 2020/11/30
 * @Modified By:
 */
@Mapper
public interface SysRoleMapper {
    SysRole selectById(Integer id);
}
