package com.taotao.order.service.impl;

import com.taotao.order.service.PayOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service("payOrderServiceCancel")
public class PayOrderServiceCancel implements PayOrderService {

    @Override
    @Transactional
    public int PayOrder(String token, String orderNum) {
        System.out.println("okokokokok");
        return 0;
    }
}
