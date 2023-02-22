package com.dextris.dextris.controller;

import com.dextris.dextris.entity.Role;
import com.dextris.dextris.service.RoleService;
import com.dextris.dextris.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;
    public RoleController( ) {
        System.out.println(this.getClass().getSimpleName());

    }

    public RoleController(RoleServiceImpl roleService) {
        System.out.println(this.getClass().getSimpleName());
        this.roleService = roleService;
    }

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        System.out.println(" inside the createNewRole cus");


        return roleService.validateAndCreateNewRole(role);

    }


}
