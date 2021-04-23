package com.example.demo.common.config;

import com.example.demo.common.interceptor.LoginInterceptor;
import com.example.demo.utils.RelativePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @PROJECT_NAME: lemon
 * @PACKAGE_NAME: com.example.lemon.common.config
 * @Class_NAME: WebConfigurer
 * @Author: zhangyongjiang
 * @DATE_TIME: 2020-12-21 下午 06:54
 * @Description:
 * @version:
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Value("${maxFileSize}")
    private String maxFileSize;

    @Value("${maxRequestSize}")
    private String maxRequestSize;

    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 匹配url 中的资源映射
     */
    @Value("${accessFile.resourceHandler}")
    private String resourceHandler;

    /**
     * 上传文件保存的本地目录
     */
    @Value("${accessFile.location}")
    private String location;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 匹配到resourceHandler,将URL映射至location,也就是本地文件夹
         */

        registry.addResourceHandler(resourceHandler).addResourceLocations("file:" + RelativePath.property + location);
    }

    /**
     * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 表示拦截所有的请求，
         */
        //addPathPatterns("/**")
        /**
         * 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
         */
        //excludePathPatterns("/login", "/register")
        /**
         * 进行登录检验
         */
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login", "/user/register", "/image/upload", "/images/**");
    }

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        /**
         * 单个文件最大KB,MB
         */
        factory.setMaxFileSize(DataSize.ofMegabytes(Long.parseLong(maxFileSize)));
        /**
         * 设置总上传数据总大小
         */
        factory.setMaxRequestSize(DataSize.ofMegabytes(Long.parseLong(maxRequestSize)));
        return factory.createMultipartConfig();
    }

    /**
     * 登录拦截配置
     * 构造器注入
     */
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    /**
     * 跨域访问配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            //允许所有的url
            //.allowedOriginPatterns("*")
            .allowedOrigins("*")
            .allowedHeaders("*")
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
