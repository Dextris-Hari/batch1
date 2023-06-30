package com.dextris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    private String roleName;

    private String roleDescription;
}
