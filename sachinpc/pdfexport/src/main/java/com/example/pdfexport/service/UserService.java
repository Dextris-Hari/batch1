package com.example.pdfexport.service;

import com.example.pdfexport.Repository.RoleRepository;
import com.example.pdfexport.Repository.UserRepository;
import com.example.pdfexport.entity.Role;
import com.example.pdfexport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> listAll() {
        return repo.findAll(Sort.by("email").ascending());
    }


    public void initRolesAndUser() {
        System.out.println(" inside the initRoleAndUser method cus");

        Role adminRole = new Role();

        adminRole.setDescription("Admin role");
        adminRole.setName("Admin");
      roleRepository  .save(adminRole);

        Role userRole = new Role();

        userRole.setDescription("Default role for the newly crated  record");
        userRole.setName("User");
        roleRepository.save(userRole);


        User adminUser = new User();
        adminUser.setFullName("adminmanoj");
        adminUser.setEmail("manoj@123");
        adminUser.setPassword("manoj@123");
        Set<Role> adminRoles = new HashSet<Role>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);

        repo.save(adminUser);

    }
}
