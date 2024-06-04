package com.example.demo.service;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.User;

public interface UserService {
    ApiResponse register(User user);

    ApiResponse login(User loginUser);
}
