package com.example.tsn.system.service;

import com.example.tsn.system.entity.CommentEntity;
import com.example.tsn.system.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {


    private CommentRepository commentRepository;

    public CommentEntity addComment(CommentEntity comment) {
        comment.setCreatedAt(new Date());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<CommentEntity> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
