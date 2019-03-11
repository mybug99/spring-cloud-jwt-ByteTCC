package com.taotao.order.service;

import com.taotao.commen.pojo.order.Order;

import java.math.BigDecimal;

public interface OrderService {
    public int CreateOrder(String uuid,int uid, String productName, BigDecimal money);

    public Order getOrder(String orderNum);


}
