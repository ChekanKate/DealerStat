package com.chekan.leverX.dao;

import com.chekan.leverX.entity.Comment;

import java.util.List;

public interface CommentDAO {
    public void saveComment(Comment comment);
    public List<Comment> getComments(int id);
    public Comment getComment(int id);
    public void updateComment(int id, int rate);

}
