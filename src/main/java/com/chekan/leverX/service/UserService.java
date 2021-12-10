package com.chekan.leverX.service;

import com.chekan.leverX.entity.User;

public interface UserService {

    void saveUser(User user);

    User getUser(int id);

    User getByUserEmail(String email);

    User getUserByActivationCode(String activationCode);

}
