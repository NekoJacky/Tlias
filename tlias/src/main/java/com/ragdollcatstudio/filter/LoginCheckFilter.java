/**
 * 登录校验过滤器
 */
package com.ragdollcatstudio.filter;

import com.alibaba.fastjson2.JSONObject;
import com.ragdollcatstudio.pojo.JwtUtils;
import com.ragdollcatstudio.pojo.Result;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;

import java.io.IOException;

// 使用 Interceptor 时为了防止冲突，注释掉过滤器
// @WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements jakarta.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURL().toString();

        if(url.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return ;
        }

        String jwt = request.getHeader("token");

        if(!StringUtils.hasLength(jwt)) {
            Result errNotLogin = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(errNotLogin);
            response.getWriter().write(notLogin);
            return ;
        }

        try{
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            Result errNotLogin = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(errNotLogin);
            response.getWriter().write(notLogin);
            return ;
        }

        filterChain.doFilter(servletRequest, servletResponse);  // 放行
    }
}
