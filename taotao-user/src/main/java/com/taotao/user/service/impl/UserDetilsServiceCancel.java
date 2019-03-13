package com.taotao.user.service.impl;

import com.taotao.commen.exception.BusinessException;
import com.taotao.user.mapper.UserDetlisMapper;
import com.taotao.user.service.UserDetilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("userDetilsServiceCancel")
public class UserDetilsServiceCancel implements UserDetilsService {
    @Autowired
    UserDetlisMapper userDetlisMapper;

    @Override
    @Transactional
    public int ReduceMoney(int uid, int money){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前进入cancel-----money" + sdf.format(new Date()));
        int i = userDetlisMapper.cancelFrozen(uid);
        System.out.println("成功操作了ReduceMoney的Cancel" + i);
        return i;
    }
}
