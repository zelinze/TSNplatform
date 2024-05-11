package com.example.tsn.system.service;

import com.example.tsn.system.entity.PostEntity;
import com.example.tsn.system.entity.UserEntity;
import com.example.tsn.system.repository.PostRepository;
import com.example.tsn.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired

    private UserRepository userRepository;

@Autowired
    private PostRepository postRepository;

    public List<UserEntity> searchUsers(String keyword) {
        return userRepository.findByUsernameContainingIgnoreCase(keyword);
    }

    public List<PostEntity> searchPosts(String keyword) {
        return postRepository.findByContentContainingIgnoreCase(keyword);
    }
}
