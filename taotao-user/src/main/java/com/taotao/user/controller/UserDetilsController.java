package com.taotao.user.controller;

import com.taotao.commen.exception.BusinessException;
import com.taotao.user.service.UserDetilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserDetilsController {

    @Resource
    UserDetilsService userDetilsServiceImpl;

    @RequestMapping("/ReduceMoney")
    @Transactional
    public int ReduceMoney(@RequestParam("uid") int uid, @RequestParam("money")int money) throws BusinessException {
        int i = userDetilsServiceImpl.ReduceMoney(uid, money);
        return i;
    }
}
