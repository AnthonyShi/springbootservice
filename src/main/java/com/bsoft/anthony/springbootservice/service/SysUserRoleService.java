package com.bsoft.anthony.springbootservice.service;

import com.bsoft.anthony.springbootservice.dao.sys.SysUserRoleMapper;
import com.bsoft.anthony.springbootservice.pojo.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:17:16 2020/11/30
 * @Modified By:
 */
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
