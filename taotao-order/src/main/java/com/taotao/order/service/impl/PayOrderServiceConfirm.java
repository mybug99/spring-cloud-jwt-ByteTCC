package com.taotao.order.service.impl;

import com.taotao.commen.Enum.ResponseEnum;
import com.taotao.commen.exception.BusinessException;
import com.taotao.commen.pojo.order.Order;
import com.taotao.commen.pojo.order.OrderExample;
import com.taotao.order.mapper.OrderMapper;
import com.taotao.order.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service("payOrderServiceConfirm")
public class PayOrderServiceConfirm implements PayOrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    @Transactional
    public int PayOrder(String token, String orderNum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前进入confirm----order" + sdf.format(new Date()));
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderNumEqualTo(orderNum);
        Order order = new Order();
        order.setOrderState(1);
        int random = new Random().nextInt(200);
        if (random > 150) {
            throw new BusinessException(ResponseEnum.UNKNOWN_ERROR);
        }
        int i = orderMapper.updateByExampleSelective(order, orderExample);
        System.out.println("成功操作了PayOrder的Confirm====" + i);
        return i;
    }
}
