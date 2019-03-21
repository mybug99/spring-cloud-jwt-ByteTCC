package com.taotao.order.controller;

import com.taotao.commen.exception.BusinessException;
import com.taotao.commen.utils.CookiesUtils;
import com.taotao.order.service.PayOrderService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

import javax.servlet.http.HttpServletRequest;

@RestController
@Compensable(
        interfaceClass = PayOrderService.class,
        confirmableKey = "payOrderServiceConfirm",
        cancellableKey = "payOrderServiceCancel"
)
public class PayController {

    @Autowired
    private PayOrderService payOrderServiceImpl;
    @Autowired
    private HttpServletRequest request; //自动注入request

    @RequestMapping("/PayOrder")
    @Transactional
    public int PayOrder(@RequestParam(value = "token", defaultValue = "0000") String token, String orderNum) throws BusinessException {
        token = CookiesUtils.getCookisToken(request);
        ModelAndView modelAndView = new ModelAndView("");
        int i = 0;
        try {
            i = payOrderServiceImpl.PayOrder(token, orderNum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (i < 0)
            return 1;
        return 2;
    }
}
