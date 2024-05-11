package com.example.tsn.system.service;

import com.example.tsn.system.entity.UserEntity;

public interface UserService {
    /**
     * 登录业务逻辑
     * @param username 账户名
     * @param password 密码
     * @return
     */
    UserEntity loginService(String username, String password);

    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中主键uid要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    UserEntity registService(UserEntity user);

    UserEntity getUserById(String id)throws Exception;

    UserEntity updateUser(String id, UserEntity userUpdates)throws Exception;
}