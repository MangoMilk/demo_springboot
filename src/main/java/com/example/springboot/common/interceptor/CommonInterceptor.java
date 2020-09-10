package com.example.springboot.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过getHeader获取jwt_token的值
        String jwtToken = request.getHeader("jwt_token");
        //判断是否有登录
        if(jwtToken!=null && jwtToken != ""){
            //jwt不空，表示有登陆，放行
            // TODO: Check Jwt
            return true;
        }else{
            //没有值，没有登录，返回到登录页面：
            request.getRequestDispatcher("/login").forward(request, response);
            //同时设置错误信息
            request.setAttribute("msg","没有权限");
            return false;
        }
    }
}
