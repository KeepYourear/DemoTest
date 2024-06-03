package com.example.demo.service.impl;

import com.example.demo.dao.UserDaoMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoMapper userDaoMapper;


    @Override
    public User register(User user) {
        userDaoMapper.register(user);
        return user;
    }

    @Override
    public User login(User loginUser) {
        return userDaoMapper.login(loginUser);
    }

}
