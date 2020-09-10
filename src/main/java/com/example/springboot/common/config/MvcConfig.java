package com.example.springboot.common.config;

import com.example.springboot.common.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludeUrls = setExcludeUrls();

        registry.addInterceptor(new CommonInterceptor()).excludePathPatterns(excludeUrls);
    }

    private List<String> setExcludeUrls() {
        List<String> excludeUrls = new ArrayList<>();
        // PAGE
        excludeUrls.add("/");
        excludeUrls.add("/login");
        excludeUrls.add("/home");

        // STATIC
        excludeUrls.add("/js/*");
        excludeUrls.add("/css/*");
        excludeUrls.add("/img/*");
        excludeUrls.add("/webjars/bootstrap/**");
        excludeUrls.add("/webjars/jquery/**");

        // API
        excludeUrls.add("/api/verify_code");
        excludeUrls.add("/api/user");

        return excludeUrls;
    }
}
