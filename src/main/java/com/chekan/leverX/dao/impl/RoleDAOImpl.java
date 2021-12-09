package com.chekan.leverX.dao.impl;

import com.chekan.leverX.dao.RoleDAO;
import com.chekan.leverX.entity.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Role getRoleByName(String name) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Role.class);
        crit.add(Restrictions.eq("name", name));
        return (Role) crit.list().get(0);
    }
}
