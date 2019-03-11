package com.taotao.zuul.filter;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.taotao.commen.pojo.user.User;
import com.taotao.commen.utils.user.JwtHelper;
import com.taotao.zuul.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTfilter extends ZuulFilter {

    @Autowired
    UserFeign userFeign;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        try {
            if (request.getRequestURI().indexOf("isLogin") > -1 || request.getRequestURI().indexOf("/auth") > -1 || request.getRequestURI().indexOf("logout") > -1) {
                return null;
            }
            //获取token信息
            String auth = getCookieToken(request);
            //校验token是否有效
            User user = new Gson().fromJson(JwtHelper.verifyToken(auth), User.class);
            //无效则确认无效跳转登陆界面
            if (user.getId() == null) {
                ctx.setSendZuulResponse(false); //不让zuul进行路由。
                response.sendRedirect("/user/isLogin");
                return response;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //异常跳入页面
            try {
                ctx.setSendZuulResponse(false);//不让zuul进行路由。
                response.sendRedirect("/user/isLogin");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return response;
        }
        return null;
    }


    /**
     * 获取token信息
     *
     * @param request
     * @return
     */
    public static String getCookieToken(HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {
                if ("token".equals(c.getName()))
                    return c.getValue();
            }
        }
        return "";
    }
}
