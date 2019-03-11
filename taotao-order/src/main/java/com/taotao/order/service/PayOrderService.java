package com.taotao.order.service;

import javax.servlet.http.HttpServletRequest;

public interface PayOrderService {

    public int PayOrder(String token, String orderNum);
}
