package com.bsoft.anthony.springbootservice.service;

import com.bsoft.anthony.springbootservice.dao.sys.SysUserRoleMapper;
import com.bsoft.anthony.springbootservice.pojo.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:17:16 2020/11/30
 * @Modified By:
 */
@Service
public class SysUserRoleService {
    // @Autowired
    // private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        List<SysUserRole> list = new ArrayList<SysUserRole>();
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setRoleId(1);
        sysUserRole.setUserId(1);
        list.add(sysUserRole);
        return list;
        // return userRoleMapper.listByUserId(userId);
    }
}
