package com.v.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v.bean.User;
import com.v.dao.UserMapper;
import com.v.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User getUserById(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
    
}
