/**
 * 登录校验拦截器
 */
package com.ragdollcatstudio.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.ragdollcatstudio.pojo.JwtUtils;
import com.ragdollcatstudio.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    // 返回 true 表示放行， 返回 false 表示拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();

        /* 这里不需要判断是否放行，/login 已经在 config.WebConfig.java 中排除在外
        if(url.contains("login")) {
            return true;
        }
        */

        String jwt = request.getHeader("token");

        if(!StringUtils.hasLength(jwt)) {
            Result errNotLogin = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(errNotLogin);
            response.getWriter().write(notLogin);
            return false;
        }

        try{
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            Result errNotLogin = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(errNotLogin);
            response.getWriter().write(notLogin);
            return false;
        }

        return true;
    }

    // 目标资源方法运行后运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 视图渲染完毕以后运行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
