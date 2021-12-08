package com.chekan.leverX.dao;

import com.chekan.leverX.entity.GameObject;
import com.chekan.leverX.entity.User;

public interface UserDAO{

    public void saveUser(User user);
    public User getUser(int id);
    public User getUserByEmail(String email);
    public User getUserByActivationCode(String activationCode);

}
