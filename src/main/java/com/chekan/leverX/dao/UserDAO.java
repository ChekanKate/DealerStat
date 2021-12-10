package com.chekan.leverX.dao;

import com.chekan.leverX.entity.User;

public interface UserDAO {

    void saveUser(User user);

    User getUser(int id);

    User getUserByEmail(String email);

    User getUserByActivationCode(String activationCode);

}
