package com.example.demo.common.advice;

import com.example.demo.common.exception.OApiException;
import com.example.demo.utils.ResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

/**
 * 全局异常处理增强类
 * 返回JSON
 * @author zhangyongjiang
 */
@RestControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public Object handlerError(Exception ex, HandlerMethod handlerMethod) {
        ex.printStackTrace();
        return ResponseUtil.general_response( ResponseUtil.CODE_EXCEPTION,
                "ExMessage: "+ ex.getMessage() +
                        " ExMethod: " + handlerMethod.getMethod().getName() +
                        " ExClass: " + handlerMethod.getBean().getClass().getName());
    }

    @ExceptionHandler(OApiException.class)
    public Object loinError(OApiException ex, HandlerMethod handlerMethod) {
        ex.printStackTrace();
        return ResponseUtil.general_response( ex.getCode(),
                "ExMessage: "+ ex.getMessage() +
                        " ExMethod: " + handlerMethod.getMethod().getName() +
                        " ExClass: " + handlerMethod.getBean().getClass().getName());
    }
}
