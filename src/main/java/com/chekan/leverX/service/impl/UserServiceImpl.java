package com.chekan.leverX.service.impl;

import com.chekan.leverX.dao.UserDAO;
import com.chekan.leverX.entity.User;
import com.chekan.leverX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public User getByUserEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    @Transactional
    public User getUserByActivationCode(String activationCode) {
        return userDAO.getUserByActivationCode(activationCode);
    }

}
