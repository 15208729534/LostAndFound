package com.example.demo.service;

import com.example.demo.utils.HttpsClient;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @PROJECT_NAME: demo01
 * @PACKAGE_NAME: com.example.demo01.service.Impl
 * @Class_NAME: WxService
 * @Author: zhangyongjiang
 * @DATE_TIME: 2021-4-21 上午 11:20
 * @Description:
 * @version:
 **/
@Service
public class WxService {

    /**
     * https://api.weixin.qq.com/sns/jscode2session?
     * appid=APPID
     * &
     * secret=SECRET
     * &
     * js_code=JSCODE
     * &
     * grant_type=authorization_code
     * @return
     */
    public Map login(String code) throws Exception {
        //用户在当前小程序的唯一标识（openid）、微信开放平台帐号下的唯一标识（unionid，若当前小程序已绑定到微信开放平台帐号）及本次登录的会话密钥（session_key）
        return HttpsClient.httpsGet(
//                "https://api.weixin.qq.com/sns/jscode2session?appid=wx0d07a8ae7dee93ec&secret=7fc778b664b953dda9b4c5c5c4bfa99e&js_code="+
//                code + "&grant_type=authorization_code");
                "https://api.weixin.qq.com/sns/jscode2session?appid=wx8b3adba720912fb3&appsecret=dc1debfe9926ab489163a2672746a537&js_code="+
                        code + "&grant_type=authorization_code");
    }
}
