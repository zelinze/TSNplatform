package com.example.tsn.system.DAO;

import com.example.tsn.system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {
    UserEntity findByUname(String uname); //通过用户名uname查找用户，注意要按照JPA的格式使用驼峰命名法
    UserEntity findByUnameAndPassword(String uname, String password);//通过用户名uname和密码查找用户
}
