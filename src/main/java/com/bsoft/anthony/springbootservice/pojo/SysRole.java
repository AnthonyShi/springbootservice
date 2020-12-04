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
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;
}
