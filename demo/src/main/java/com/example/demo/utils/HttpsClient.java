package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.exception.OApiException;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @PROJECT_NAME: demo01
 * @PACKAGE_NAME: com.example.demo01.utils
 * @Class_NAME: SSLClient
 * @Author: zhangyongjiang
 * @DATE_TIME: 2021-4-21 上午 11:33
 * @Description:
 * @version:
 **/
public class HttpsClient {
    /**
     * 读超时时间
     */
    private static final int DEFAULT_SO_TIMEOUT = 2000;
    /**
     * 连接超时时间
     */
    private static final int DEFAULT_TIMEOUT = 2000;

    public static Map httpsPost(String url, Object data) throws Exception {
        /**
         * 定义一个Post请求
         */
        HttpPost httpPost = new HttpPost(url);
        /**
         * 定义一个相应体
         */
        CloseableHttpResponse response = null;
        /**
         * 创建一个http客户端
         */
        CloseableHttpClient httpClient = HttpClients.createDefault();
        /**
         * 创建请求配置文件
         */
        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(DEFAULT_SO_TIMEOUT).
                setConnectTimeout(DEFAULT_TIMEOUT).build();
        /**
         * Post请求加载配置文件
         */
        httpPost.setConfig(requestConfig);
        /**
         * 设置请求头
         */
        httpPost.addHeader("Content-Type", "application/json");

        try {
            /**
             * 获取请求参数
             */
            StringEntity requestEntity = new StringEntity(JSON.toJSONString(data), "utf-8");
            /**
             * 加载请求参数
             */
            httpPost.setEntity(requestEntity);
            /**
             * 执行Post请求
             */
            response = httpClient.execute(httpPost, new BasicHttpContext());
            /**
             * 若响应不成功，直接返回null
             */
            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);
                return null;
            }
            /**
             * 解析响应体
             */
            HttpEntity entity = response.getEntity();
            /**
             * 若响应体不为空
             */
            if (entity != null) {
                /**
                 * 将其转换成utf-8编码的字符串
                 */
                String resultStr = EntityUtils.toString(entity, "utf-8");
                /**
                 * 将字符串转换成JSON格式
                 */
                JSONObject result = JSON.parseObject(resultStr);
                /**
                 * 判断响应code
                 */
                if (result.getInteger("errcode") == null || result.getInteger("errcode") == 0) {
                    result.remove("errcode");
                    result.remove("errmsg");
                    return JSON.parseObject(JSON.toJSONString(result), Map.class);
                } else {
                    System.out.println("request url=" + url + ",return value=");
                    System.out.println(resultStr);
                    int errCode = result.getInteger("errcode");
                    String errMsg = result.getString("errmsg");
                    throw new Exception(errMsg);
                }
            }
        } catch (IOException e) {
            System.out.println("request url=" + url + ", exception, msg=" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Map httpsGet(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(DEFAULT_SO_TIMEOUT).
                setConnectTimeout(DEFAULT_TIMEOUT).build();

        httpGet.setConfig(requestConfig);

        try {
            response = httpClient.execute(httpGet, new BasicHttpContext());

            if (response.getStatusLine().getStatusCode() != 200) {

                System.out.println("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {

                String resultStr = EntityUtils.toString(entity, "utf-8");
                JSONObject result = JSON.parseObject(resultStr);

                if (result.getInteger("errcode") == null || result.getInteger("errcode") == 0) {
                    return JSON.parseObject(JSON.toJSONString(result), Map.class);
                } else {
                    System.out.println("request url=" + url + ",return value=");
                    int errCode = result.getInteger("errcode");
                    String errMsg = result.getString("errmsg");
                    throw new OApiException(errCode, errMsg);
                }
            }
        } catch (IOException e) {
            System.out.println("request url=" + url + ", exception, msg=" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}