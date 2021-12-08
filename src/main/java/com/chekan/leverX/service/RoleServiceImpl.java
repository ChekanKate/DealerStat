package com.chekan.leverX.service;

import com.chekan.leverX.dao.RoleDAO;
import com.chekan.leverX.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }
}
