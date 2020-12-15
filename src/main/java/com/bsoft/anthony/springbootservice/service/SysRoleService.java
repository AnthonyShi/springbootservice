package com.bsoft.anthony.springbootservice.service;

import com.bsoft.anthony.springbootservice.dao.sys.SysRoleMapper;
import com.bsoft.anthony.springbootservice.pojo.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:17:15 2020/11/30
 * @Modified By:
 */
@Service
public class SysRoleService {
    // @Autowired
    // private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        SysRole sysRole = new SysRole();
        sysRole.setId(1);
        sysRole.setName("ROLE_ADMIN");
        return sysRole;
        // return roleMapper.selectById(id);
    }
}
