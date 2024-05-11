package com.example.tsn.system.controller;

import com.example.tsn.system.entity.UserEntity;
import com.example.tsn.system.service.UserService;
import com.example.tsn.basic.RespEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RespEntity<UserEntity> loginController(@RequestParam String username, @RequestParam String password){
        UserEntity user = userService.loginService(username, password);
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

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable String id) {
        try {
            UserEntity user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserEntity userUpdates) {
        try {
            UserEntity updatedUser = userService.updateUser(id, userUpdates);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}