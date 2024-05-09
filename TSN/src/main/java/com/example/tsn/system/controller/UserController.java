package com.example.tsn.system.controller;

import com.example.tsn.system.entity.UserEntity;
import com.example.tsn.system.service.UserService;
import com.example.tsn.basic.RespEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public RespEntity<UserEntity> loginController(@RequestParam String uname, @RequestParam String password){
        UserEntity user = userService.loginService(uname, password);
        if(user!=null){
            return RespEntity.success(user,"登录成功！");
        }else{
            return RespEntity.error("123","账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public RespEntity<UserEntity> registController(@RequestBody UserEntity newUser){
        UserEntity user = userService.registService(newUser);
        if(user!=null){
            return RespEntity.success(user,"注册成功！");
        }else{
            return RespEntity.error("456","用户名已存在！");
        }
    }
}