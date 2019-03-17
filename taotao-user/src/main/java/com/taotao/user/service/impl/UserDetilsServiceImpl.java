package com.taotao.user.service.impl;

import com.taotao.commen.Enum.ResponseEnum;
import com.taotao.commen.exception.BusinessException;
import com.taotao.commen.pojo.user.UserDetlis;
import com.taotao.commen.pojo.user.UserDetlisExample;
import com.taotao.commen.pojo.user.UserExample;
import com.taotao.user.mapper.UserDetlisMapper;
import com.taotao.user.service.UserDetilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service("userDetilsServiceImpl")
public class UserDetilsServiceImpl implements UserDetilsService {

    @Autowired
    UserDetlisMapper userDetlisMapper;


    @Override
    @Transactional
    public int ReduceMoney(int uid, int money) throws BusinessException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前进入try----money" + sdf.format(new Date()));
        UserDetlisExample userDetlisExample = new UserDetlisExample();
        userDetlisExample.createCriteria().andUIdEqualTo(uid);
        List<UserDetlis> userDetlis = userDetlisMapper.selectByExample(userDetlisExample);
        if (!userDetlis.isEmpty()) {
            if (userDetlis.get(0).getMoney() < Long.parseLong(money + "")) {
                throw new BusinessException(ResponseEnum.USER_ERROR_MONEY);
            } else if (userDetlis.get(0).getMoneyStatus() == 1) {
                System.out.println("资金冻结");
                throw new BusinessException(ResponseEnum.USER_MONEY_FROZEN);
            }
        } else {
            throw new BusinessException(ResponseEnum.USER_ERROR);
        }
        return userDetlisMapper.tryFrozen(uid);
    }
}
