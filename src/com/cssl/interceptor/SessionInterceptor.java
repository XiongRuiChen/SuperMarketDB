package com.cssl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的路径
        String requestURI = request.getRequestURI();

        // 判断请求的路径是否是登录相关的路径
        if (requestURI.contains("/login") || requestURI.contains("login.do")) {
            return true; // 放行请求
        }

        // 检查会话中是否存在 "USER" 属性
        Object user = WebUtils.getSessionAttribute(request, "USER");
        if (user == null) {
            // 重定向到 login.jsp 页面
            response.sendRedirect(request.getContextPath() + "/pleacelogin.jsp");
            return false; // 终止请求处理
        }
        return true; // 允许请求继续处理
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理完成后执行，进行一些后处理操作----------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("视图渲染完成后执行,可以进行一些清理操作----------");
    }
}
