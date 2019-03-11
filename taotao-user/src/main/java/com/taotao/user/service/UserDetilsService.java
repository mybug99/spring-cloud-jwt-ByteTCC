package com.taotao.user.service;

import com.taotao.commen.exception.BusinessException;

public interface UserDetilsService {

    public int ReduceMoney(int uid,int money) throws BusinessException;
}
