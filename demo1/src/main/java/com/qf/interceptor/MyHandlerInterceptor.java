package com.qf.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {

    /**
     * 预处理，controller方法执行前
     * return true 放行，执行下一个拦截器，如果没有，执行controller中的方法
     * return false不放行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();
        StringBuilder builder = new StringBuilder(url);
        builder.append("?method=");
        String method = request.getParameter("method");
        if (url.contains("jsp/behind/login.jsp") || builder.toString().contains("UserServlet?method=") && method.equals("adminUser") || url.contains("/css/") ||
                url.contains("/js/") || url.contains("/fonts/") || url.contains("/images/")){
            return true;
        }
        return true;
    }

    //后处理方法，controller方法执行后，success.jsp执行之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //success.jsp页面执行后，该方法会执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
