package com.bsoft.anthony.springbootservice.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:16:58 2020/11/30
 * @Modified By:
 */
@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;
}
