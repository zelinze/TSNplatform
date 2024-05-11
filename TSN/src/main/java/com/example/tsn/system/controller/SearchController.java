package com.example.tsn.system.controller;

import com.example.tsn.system.service.SearchService;
import com.example.tsn.system.entity.UserEntity;
import com.example.tsn.system.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> searchUsers(@RequestParam String keyword) {
        List<UserEntity> users = searchService.searchUsers(keyword);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostEntity>> searchPosts(@RequestParam String keyword) {
        List<PostEntity> posts = searchService.searchPosts(keyword);
        return ResponseEntity.ok(posts);
    }
}
