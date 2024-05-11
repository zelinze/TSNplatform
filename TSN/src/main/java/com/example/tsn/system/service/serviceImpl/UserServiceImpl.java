package com.example.tsn.system.service.serviceImpl;

import com.example.tsn.system.entity.UserEntity;
import com.example.tsn.system.DAO.UserDAO;
import com.example.tsn.system.repository.UserRepository;
import com.example.tsn.system.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDao;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity loginService(String username, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        UserEntity user = userDao.findByUsernameAndPassword(username, password);
        // 重要信息置空
        if(user != null){
            user.setPassword("");
        }
        return user;
    }

    public UserEntity getUserById(String id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found with ID: " + id));
    }

    public UserEntity updateUser(String id, UserEntity userUpdates) throws Exception {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found with ID: " + id));
        // Update only the fields that are allowed to be updated
        if (userUpdates.getUsername() != null) user.setUsername(userUpdates.getUsername());
        if (userUpdates.getEmail() != null) user.setEmail(userUpdates.getEmail());
        if (userUpdates.getName() != null) user.setName(userUpdates.getName());
        if (userUpdates.getPassword() != null) user.setPassword(passwordEncoder.encode(userUpdates.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public UserEntity registService(UserEntity user) {
        //当新用户的用户名已存在时
        if(userDao.findByUsername(user.getUsername())!=null){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            UserEntity newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
