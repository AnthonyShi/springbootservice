package com.bsoft.anthony.springbootservice.response;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;

//import lombok.Data;

/**
 * 所有消息返回的封装类
 * @param <T>
 */
//@Data
@XmlSeeAlso({ArrayList.class})
public class ResponseEntity<T> {
    private int code= ResponseStatus.SUCCESS_CODE;
    private String message = ResponseStatus.SUCCESS_MSG;
    
    private T data = null;

    public ResponseEntity() {}

    public ResponseEntity(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T responseData) {
        this.data = responseData;
    }
}
