package com.deng.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String loginUser = (String) request.getSession().getAttribute("loginUser");

        if (!StringUtils.isEmpty(loginUser)){
            return true;
        }else {
            request.setAttribute("msg","你无权查看，请重新登陆！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }

    }
}
