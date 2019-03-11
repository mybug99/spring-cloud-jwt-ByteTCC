package com.taotao.user.service;

import com.taotao.user.mapper.UserMapper;
import com.taotao.commen.pojo.user.User;
import com.taotao.commen.pojo.user.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User authUser(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0)
            return users.get(0);
        return new User();
    }
}
