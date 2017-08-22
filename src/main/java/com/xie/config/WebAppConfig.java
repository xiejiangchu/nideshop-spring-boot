package com.xie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author xie
 * @Date 17/1/20 下午2:44.
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(csrfHandlerInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(adminInteceptor).addPathPatterns("/admin/**")
//                .excludePathPatterns("/index", "/login", "/upload", "webjars/**", "/v2/**", "/banners/**", "/css/**", "/js/**", "/images/**", "/**/*.html")
//                .excludePathPatterns("/admin/login", "/admin/register","/admin/document");
//        registry.addInterceptor(loginInteceptor).addPathPatterns("/**")
//                .excludePathPatterns("/admin/**", "/index", "/login", "/upload", "webjars/**", "/v2/**", "/banners/**", "/css/**", "/js/**", "/images/**", "/**/*.html")
//                .excludePathPatterns("/admin/login", "/admin/register");
        super.addInterceptors(registry);
    }
}
