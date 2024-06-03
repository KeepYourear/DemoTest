package com.example.demo.controller;

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
    public User register(@RequestBody User user){
        userService.register(user);
        return user;
    }

    @GetMapping("/login")
    public String login(@RequestBody User loginUser){
        User user = userService.login(loginUser);
        if (user != null){
            return "登陆成功";
        }
        else return "登陆失败";
    }

}
