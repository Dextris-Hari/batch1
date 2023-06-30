package com.dextris.service.impl;

import com.dextris.entity.Role;
import com.dextris.repository.RoleRepository;
import com.dextris.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role validateAndCreateNewRole(Role role) {
        return roleRepository.save(role);
    }
}
