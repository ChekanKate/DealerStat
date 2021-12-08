package com.chekan.leverX.dao;

import com.chekan.leverX.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
        crit.add(Restrictions.eq("email", email));
        return (User) crit.list().get(0);
    }

    @Override
    public User getUserByActivationCode(String activationCode) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
        crit.add(Restrictions.eq("activationCode", activationCode));
        return (User) crit.list().get(0);
    }
}
