package com.chekan.leverX.dao;

import com.chekan.leverX.entity.Comment;

import java.util.List;

public interface CommentDAO {

    void saveComment(Comment comment);

    List<Comment> getComments(int id);

    Comment getComment(int id);

    void deleteComment(int id);
}
