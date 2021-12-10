package com.chekan.leverX.service;

import com.chekan.leverX.entity.Comment;

import java.util.List;

public interface CommentService {

    void saveComment(Comment comment);

    List<Comment> getComments(int id);

    Comment getComment(int id);

    void deleteComment(int id);

}
