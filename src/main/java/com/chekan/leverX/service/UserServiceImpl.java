package com.chekan.leverX.service;

import com.chekan.leverX.dao.UserDAO;
import com.chekan.leverX.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
}
