package com.bsoft.anthony.springbootservice.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:AnthonyShi
 * @Description:
 * @Date:16:57 2020/11/30
 * @Modified By:
 */
@Data
public class SysUser implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;
}
