package com.dextris.dextris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Role {


    @Id
    private String roleName;

    private String roleDescription;

    public Role(String roleName, String roleDescription) {
        System.out.println(" inside the para"+ this.getClass().getSimpleName());
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public Role() {
        System.out.println(" inside no para"+this.getClass().getSimpleName());
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
