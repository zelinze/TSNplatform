package com.example.tsn.system.controller;


import com.example.tsn.system.entity.PostEntity;
import com.example.tsn.system.entity.UserEntity;
import com.example.tsn.system.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody PostEntity post) {
        PostEntity createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostEntity> updatePost(@PathVariable Long postId, @RequestBody PostEntity post) {
        PostEntity updatedPost = postService.updatePost(postId, post);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getPostsByUserId(@PathVariable String userId) {
        List<PostEntity> posts = postService.getPostsByUserId(userId);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<String> likePost(@PathVariable Long postId, @RequestBody UserEntity user) {
        if (postService.likePost(postId, user)) {
            return ResponseEntity.ok("Post liked successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to like post");
        }
    }

    @PostMapping("/{postId}/unlike")
    public ResponseEntity<String> unlikePost(@PathVariable Long postId, @RequestBody UserEntity user) {
        if (postService.unlikePost(postId, user)) {
            return ResponseEntity.ok("Post unliked successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to unlike post");
        }
    }
}
