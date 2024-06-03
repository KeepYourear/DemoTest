package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDaoMapper {
    // 注册
    void register(User user);
    // 登录
    User login(User loginUser);
}
