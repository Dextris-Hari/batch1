package com.dextris.dextris.service.impl;

import com.dextris.dextris.entity.Role;
import com.dextris.dextris.repository.RoleRepository;
import com.dextris.dextris.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public RoleServiceImpl() {
        System.out.println(this.getClass().getSimpleName());

    }

    public RoleServiceImpl(RoleRepository roleRepository) {
        System.out.println("para con"+ this.getClass().getSimpleName());
        this.roleRepository = roleRepository;
    }

    @Override
    public Role validateAndCreateNewRole(Role role) {

        System.out.println(" inside the validateAndSave method cus ");

        return roleRepository.save(role);
    }
}
