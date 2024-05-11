package com.example.tsn.system.repository;

import com.example.tsn.system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    // Find a user by their username (assumed unique)
    Optional<UserEntity> findByUsername(String username);

    // Check if a username exists in the database
    boolean existsByUsername(String username);

    // Authenticate a user by username and password
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    List<UserEntity> findByUsernameContainingIgnoreCase(String username);
}

