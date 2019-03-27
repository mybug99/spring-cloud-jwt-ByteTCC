package com.taotao.order.controller;

import com.google.gson.Gson;
import com.taotao.commen.pojo.order.Order;
import com.taotao.commen.pojo.user.User;
import com.taotao.commen.utils.CookiesUtils;
import com.taotao.commen.utils.user.JwtHelper;
import com.taotao.order.Feign.UserFeign;
import com.taotao.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.UUID;

@RefreshScope
@Controller
public class OrderCreateController {

    @Autowired
    OrderService orderServiceImpl;
    @Autowired
    UserFeign userFeign;

    @Value("${hey}")
    private String showName;


    @RequestMapping("/order")
    public String order(){
        return "createOrder";
    }

    @RequestMapping("/payOrder")
    public String orderCreate(HttpServletRequest request, String productName, String money, @RequestHeader("Referer") String url) {
        String token = CookiesUtils.getCookisToken(request);
        if (token.equals(""))
            return "redirect:" + url;
        User user = new Gson().fromJson(JwtHelper.verifyToken(token), User.class);
        String uuid = UUID.randomUUID().toString();
        BigDecimal bigDecimal = new BigDecimal(money);
        int i = orderServiceImpl.CreateOrder(uuid, user.getId(), productName, bigDecimal);
        if (i > 0) {
            return "redirect:/order/getOrder?orderNum=" + uuid;
        }
        return "eoore";
    }

    @RequestMapping("/getOrder")
    public ModelAndView getOrder(String orderNum) {
        ModelAndView mv = new ModelAndView("order");
        Order order = orderServiceImpl.getOrder(orderNum);
        mv.addObject("order", order);
        return mv;
    }

    @RequestMapping("/showName")
    @ResponseBody
    public String showName(){
        return showName;
    }


    @RequestMapping("/hello/{hello}")
    @ResponseBody
    public String hello(@PathVariable("hello")String hello){
        return userFeign.hello(hello);
    }

}
