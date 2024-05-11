package com.example.tsn.system.controller;

import com.example.tsn.system.entity.CommentEntity;
import com.example.tsn.system.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentEntity> addComment(@RequestBody CommentEntity comment) {
        CommentEntity createdComment = commentService.addComment(comment);
        return ResponseEntity.ok(createdComment);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentEntity> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentEntity>> getCommentsByPostId(@PathVariable Long postId) {
        List<CommentEntity> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }
}
