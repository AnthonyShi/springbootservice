package com.bsoft.anthony.springbootservice.service;

import com.bsoft.anthony.springbootservice.dao.sys.SysUserMapper;
import com.bsoft.anthony.springbootservice.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:17:12 2020/11/30
 * @Modified By:
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
