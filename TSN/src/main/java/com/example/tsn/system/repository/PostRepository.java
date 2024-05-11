package com.example.tsn.system.repository;

import com.example.tsn.system.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByContentContainingIgnoreCase(String content);
    List<PostEntity> findByUserId(String Id);
}

