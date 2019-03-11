package com.taotao.commen.utils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookiesUtils {

    public static String getCookisToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if("token".equals(cookie.getName()))
                return cookie.getValue();
        }
        return "";
    }
}
