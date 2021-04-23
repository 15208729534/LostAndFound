package com.example.demo.common.exception;

import lombok.Data;

@Data
public class OApiException extends Exception {
    private Integer code;
    public OApiException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
}
