package com.chekan.leverX.service;

import com.chekan.leverX.entity.Comment;

import java.util.List;

public interface CommentService {
    public void saveComment(Comment comment);
    public List<Comment> getComments(int id);
    public Comment getComment(int id);
    public void deleteComment(int id);
}
