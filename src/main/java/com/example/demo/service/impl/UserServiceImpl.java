package com.example.demo.service.impl;

import com.example.demo.dao.UserDaoMapper;
import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoMapper userDaoMapper;


    @Override
    public ApiResponse register(User registerUser) {
        User user = userDaoMapper.getUserByPhone(registerUser.getPhone());
        if (user != null) {
            return new ApiResponse(400, "该手机号已注册");
        }
        registerUser.setPassword(SecurityUtils.encodePassword(registerUser.getPassword()));
        userDaoMapper.register(registerUser);
        return new ApiResponse(200, "注册成功");

    }

    @Override
    public ApiResponse login(User loginUser) {
        User user = userDaoMapper.getUserByPhone(loginUser.getPhone());
        if (user != null) {
            String loginPassword = loginUser.getPassword();
            String dbPassword = user.getPassword();
            if (SecurityUtils.matchPassword(loginPassword, dbPassword)){
                return new ApiResponse(200, "登录成功");
            }
            else {
                return new ApiResponse(400, "登陆失败，密码错误");
            }
        }
        else {
            return new ApiResponse(400, "登陆失败，手机号不存在");
        }

    }

}
