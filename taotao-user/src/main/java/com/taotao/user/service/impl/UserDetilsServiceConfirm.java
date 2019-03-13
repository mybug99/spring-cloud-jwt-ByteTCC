package com.taotao.user.service.impl;

import com.taotao.user.mapper.UserDetlisMapper;
import com.taotao.user.service.UserDetilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("userDetilsServiceConfirm")
public class UserDetilsServiceConfirm implements UserDetilsService {


    @Autowired
    UserDetlisMapper userDetlisMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    @Transactional
    public int ReduceMoney(int uid, int money){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前进入confirm-----Money" + sdf.format(new Date()));
        int i = userDetlisMapper.confirmReduceMoney(uid, money);
        System.out.println("成功操作了ReduceMoney的Confirm==" + i);
        return i;
    }
}
