package com.chekan.leverX.dao;

import com.chekan.leverX.entity.Comment;
import com.chekan.leverX.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where id=:id", User.class);
        query.setParameter("id", id);
        User user = query.getSingleResult();
        return user;
    }
}
