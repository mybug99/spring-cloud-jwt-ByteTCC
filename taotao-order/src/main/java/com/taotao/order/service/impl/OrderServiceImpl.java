package com.taotao.order.service.impl;

import com.google.gson.Gson;
import com.taotao.commen.pojo.order.Order;
import com.taotao.commen.pojo.order.OrderExample;
import com.taotao.commen.pojo.user.User;
import com.taotao.commen.utils.user.JwtHelper;
import com.taotao.order.Feign.UserFeign;
import com.taotao.order.mapper.OrderMapper;
import com.taotao.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    @Transactional
    public int CreateOrder(String uuid, int uid, String productName, BigDecimal money) {
        Order order = new Order();
        order.setOrderNum("PR_" + uuid);
        order.setMoney(money + "");
        order.setProductName(productName);
        order.setUid(uid);
        order.setOrderState(0);
        order.setUpdateTime(new Date());
        order.setCreateTime(new Date());
        return orderMapper.insertSelective(order);
    }

    @Override
    public Order getOrder(String orderNum) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderNumEqualTo("PR_" + orderNum);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        if (orderList.size() > 0)
            return orderList.get(0);
        return new Order();
    }


}
