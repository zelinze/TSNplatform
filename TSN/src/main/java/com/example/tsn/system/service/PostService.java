package com.example.tsn.system.service;

import com.example.tsn.system.entity.PostEntity;
import com.example.tsn.system.entity.UserEntity;
import com.example.tsn.system.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity createPost(PostEntity post) {
        post.setCreatedAt(new Date());
        return postRepository.save(post);
    }

    public PostEntity updatePost(Long postId, PostEntity updatedPost) {
        PostEntity post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setContent(updatedPost.getContent());
        post.setUpdatedAt(new Date());
        return postRepository.save(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public List<PostEntity> getPostsByUserId(String userId) {
        return postRepository.findByUserId(userId);
    }

    public boolean likePost(Long postId, UserEntity user) {
        Optional<PostEntity> postOpt = postRepository.findById(postId);
        if (postOpt.isPresent()) {
            PostEntity post = postOpt.get();
            boolean added = post.getLikedBy().add(user);
            postRepository.save(post);
            return added;
        }
        return false;
    }

    public boolean unlikePost(Long postId, UserEntity user) {
        Optional<PostEntity> postOpt = postRepository.findById(postId);
        if (postOpt.isPresent()) {
            PostEntity post = postOpt.get();
            boolean removed = post.getLikedBy().remove(user);
            postRepository.save(post);
            return removed;
        }
        return false;
    }
}