package com.bsoft.anthony.springbootservice.utils;

import lombok.Data;

/**
 * 创建日期 : 2019/6/12
 * 创建人 : 赵太行
 */
@Data
public class BaseResponse<T> {
    private String message;
    private Integer code;
    private T data;
}
