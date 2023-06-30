package com.dextris.controller;

import com.dextris.entity.Role;
import com.dextris.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RoleController {
    @Autowired
    private RoleService roleService;

    public  RoleController(RoleService roleService){
        this.roleService=roleService;
    }
    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.validateAndCreateNewRole(role);

    }
}
