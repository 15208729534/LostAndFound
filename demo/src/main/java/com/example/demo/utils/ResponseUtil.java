package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.example.attendance.utils
 * @Class_NAME: ResponseUtil
 * @Author: zhangyongjiang
 * @DATE_TIME: 2021-04-16 18:24
 * @Description: 统一响应类
 * @version:
 **/
public class ResponseUtil {
    public static final int CODE_OK = 200;
    public static final int CODE_ERROR = 402;
    public static final int CODE_EXCEPTION = 405;

    public static Map<Object,Object> general_response(Integer statusCode, String msg, Object data, Map<Object, Object> args) {
        Map<Object, Object> map = new HashMap<>();
        map.put("code", statusCode);
        map.put("msg", msg);
        map.put("data", data);
        if (args != null) {
            for (Map.Entry<Object, Object> entry : args.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public static Map<Object,Object> general_response(Integer statusCode, String msg, Object data){
        return general_response(statusCode, msg, data, null);
    }

    public static Map<Object,Object> general_response(Integer statusCode, String msg){
        return general_response(statusCode, msg, null, null);
    }

    public static Map<Object,Object> general_response(Integer statusCode){
        return general_response(statusCode);
    }

    public static Map<Object,Object> general_response(String msg, Object data, Map<Object, Object> args){
        return general_response(CODE_OK, msg, data, args);
    }

    public static Map<Object,Object> general_response(String msg, Object data){
        return general_response(CODE_OK, msg, data, null);
    }

    public static Map<Object,Object> general_response(String msg){
        return general_response(CODE_OK, msg, null, null);
    }

    public static Map<Object,Object> general_response(Object data){
        return general_response(CODE_OK, "success", data, null);
    }

    public static Map<Object,Object> general_response(Map<Object, Object> args){
        return general_response(CODE_OK, "success", null, args);
    }
}
