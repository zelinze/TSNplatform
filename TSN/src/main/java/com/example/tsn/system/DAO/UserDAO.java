package com.example.tsn.system.DAO;

import com.example.tsn.system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username); //通过用户名uname查找用户，注意要按照JPA的格式使用驼峰命名法
    UserEntity findByUsernameAndPassword(String username, String password);//通过用户名uname和密码查找用户

}
