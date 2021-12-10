package com.chekan.leverX.dao.impl;

import com.chekan.leverX.dao.CommentDAO;
import com.chekan.leverX.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(comment);
    }

    @Override
    public List<Comment> getComments(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Comment> query = session.createQuery("from Comment where post_id=:postId", Comment.class);
        query.setParameter("postId", id);
        List<Comment> allComments = query.getResultList();
        return allComments;
    }

    @Override
    public Comment getComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Comment comment = session.get(Comment.class, id);
        return comment;
    }

    @Override
    public void deleteComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Comment> query = session.createQuery("delete from Comment where id=:commentId");
        query.setParameter("commentId", id);
        query.executeUpdate();
    }

}
