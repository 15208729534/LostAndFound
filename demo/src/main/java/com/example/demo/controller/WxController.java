package com.example.demo.controller;

import com.example.demo.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class WxController {

    @Autowired
    private WxService wxService;

    @GetMapping("/Wx")
    public Object login(@RequestParam(value = "code") String code) throws Exception {
        System.out.println(code);

        Map<String, String> map = wxService.login(code);

        System.out.println(map.get("openid"));
        return map;
    }
}
