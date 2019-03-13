package com.taotao.order.service;

import com.taotao.commen.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;

public interface PayOrderService {

    public int PayOrder(String token, String orderNum) throws BusinessException;
}
