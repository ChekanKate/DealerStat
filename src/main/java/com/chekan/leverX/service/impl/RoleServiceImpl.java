package com.chekan.leverX.service.impl;

import com.chekan.leverX.dao.RoleDAO;
import com.chekan.leverX.entity.Role;
import com.chekan.leverX.service.RoleService;
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
