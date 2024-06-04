package com.example.demo.controller;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse register(@RequestBody User registerUser){
        if (!validateUser(registerUser, true)){
            return new ApiResponse(400,"效验失败，参数错误");
        }
        return userService.register(registerUser);

    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody User loginUser){
        if (!validateUser(loginUser, false)){
            return new ApiResponse(400,"效验失败，参数错误");
        }
        return userService.login(loginUser);
    }

    private boolean validateUser(User user,boolean isRegister){
        String phone = user.getPhone();
        String password = user.getPassword();
        String nickname = user.getNickname();
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        if (isRegister) {
            return nickname != null && !nickname.isEmpty();
        }
        return true;

    }

}
