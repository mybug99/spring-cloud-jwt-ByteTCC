package com.taotao.order.service.impl;

import com.google.gson.Gson;
import com.taotao.commen.Enum.ResponseEnum;
import com.taotao.commen.exception.BusinessException;
import com.taotao.commen.pojo.order.Order;
import com.taotao.commen.pojo.order.OrderExample;
import com.taotao.commen.pojo.user.User;
import com.taotao.commen.utils.user.JwtHelper;
import com.taotao.order.Feign.UserFeign;
import com.taotao.order.mapper.OrderMapper;
import com.taotao.order.service.PayOrderService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("payOrderServiceImpl")
public class PayOrderServiceImpl implements PayOrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserFeign userFeign;

    @Override
    @Transactional
    public int PayOrder(String token, String orderNum) throws BusinessException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前进入try----order" + sdf.format(new Date()));
        User user = new Gson().fromJson(JwtHelper.verifyToken(token), User.class);
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderNumEqualTo(orderNum);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        Order order = orderList.get(0);
        if (order.getOrderState() == 1) {
            throw new BusinessException(ResponseEnum.ORDER_PAY);
        }
        int i = userFeign.ReduceMoney(user.getId(), Integer.parseInt(order.getMoney()));
        if (i < 0) {
            return i;
        }
        return 1;
    }
}
