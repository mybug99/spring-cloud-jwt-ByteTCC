package com.taotao.user.controller;

import com.taotao.commen.Enum.ResponseEnum;
import com.taotao.commen.exception.BusinessException;
import com.taotao.commen.pojo.user.User;
import com.taotao.user.service.UserService;
import com.taotao.commen.utils.user.JwtHelper;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RefreshScope
public class UserController {

    @Autowired
    UserService userService;

    @Value("${lia.names}")
    String names;

    @RequestMapping("/isLogin")
    public String isLogin() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/hey")
    @ResponseBody
    public String hey(){
        return names;
    }

    @RequestMapping("/auth")
    @HystrixCommand(fallbackMethod = "authFallback")
    public String Login(HttpServletResponse response, String username, String password ) throws BusinessException {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return "login";
        }
        User user = userService.authUser(username);
        if (password.equals(user.getPassword())) {
            String token = JwtHelper.getToken(user);
            user.setToken(token);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/user/index";
        }
        return "login";
    }

    @RequestMapping("/inToken/{token}")
    @ResponseBody
    public User authToken(@PathVariable String token) throws BusinessException {
        if (StringUtils.isBlank(token)) {
            throw new BusinessException(ResponseEnum.USER_ERROR_TOKEN);
        }
        String result = JwtHelper.verifyToken(token); //校验tiken是否有效
        User user = new Gson().fromJson(result, User.class);
        user.setToken(token);
        if (user != null)
            return user;
        throw new BusinessException(ResponseEnum.USER_ERROR_TOKEN);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("token", "");
        response.addCookie(cookie);
        return "redirect:/user/index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("hello")String hello){
        return "hello "+hello;
    }
    public String authFallback(HttpServletResponse response, String username, String password) throws BusinessException {
        throw new BusinessException(ResponseEnum.USER_ERROR_USERNAME);
    }




}
