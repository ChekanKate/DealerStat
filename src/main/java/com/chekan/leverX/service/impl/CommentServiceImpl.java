package com.chekan.leverX.service.impl;

import com.chekan.leverX.dao.CommentDAO;
import com.chekan.leverX.entity.Comment;
import com.chekan.leverX.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Transactional
    @Override
    public void saveComment(Comment comment) {
        commentDAO.saveComment(comment);
    }

    @Transactional
    @Override
    public List<Comment> getComments(int id) {
        return commentDAO.getComments(id);
    }

    @Transactional
    @Override
    public Comment getComment(int id) {
        return commentDAO.getComment(id);
    }

    @Transactional
    @Override
    public void deleteComment(int id) {
        commentDAO.deleteComment(id);
    }

}
