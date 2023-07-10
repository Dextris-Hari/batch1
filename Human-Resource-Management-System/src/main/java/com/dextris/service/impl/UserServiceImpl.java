package com.dextris.service.impl;

import com.dextris.entity.Role;
import com.dextris.entity.User;
import com.dextris.repository.RoleRepository;
import com.dextris.repository.UserRepository;
import com.dextris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl( UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        System.out.println("thale novu");
    }

    public UserServiceImpl() {

    }

    @Override
    public User validateAndCreateNewUser(User user) throws IOException {

        Integer count = 0;
        user.setCount(count);
        user.setStatus("unblocked");
        System.out.println(" inside the validateAndCreateNewUser method cus");

        Role role = roleRepository.findById("User").get();
        Set roles = new HashSet();
        roles.add(role);
        user.setRole(roles);
        user.setDateOfBirth(new Date());

        user.setNewPassword(getEncodedPassword(user.getNewPassword()));


        return userRepository.save(user);
    }
    @Override
    public void initRolesAndUser() {
        System.out.println(" inside the initRoleAndUser method cus");

        Role adminRole = new Role();

        adminRole.setRoleDescription("Admin role");
        adminRole.setRoleName("Admin");
        roleRepository.save(adminRole);

        Role userRole = new Role();

        userRole.setRoleDescription("Default role for the newly crated  record");
        userRole.setRoleName("User");
        roleRepository.save(userRole);


        User adminUser = new User();
        adminUser.setUserName("adminmanoj");
        adminUser.setDateOfBirth(new Date());
        adminUser.setGender("male");
        adminUser.setEmail("manoj@123");
        adminUser.setPhoneNumber(7204250720L);
        adminUser.setNewPassword(getEncodedPassword("manoj@123"));

        adminUser.setStatus("unblocked");
        Set<Role> adminRoles = new HashSet<Role>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);

        userRepository.save(adminUser);


//        User user = new User();
//        user.setUserName("user");
//        user.setLastName("h j");
//        user.setDateOfBirth(new Date());
//        user.setEmail("manoj@1998");
//        user.setNewPassword(getEncodedPassword("manoj@1998"));
//        user.setPhoneNumber(9482560881L);
//        Set<Role> userRoles= new HashSet<Role>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userRepository.save(user);


    }

    public String getEncodedPassword(String password) {
        System.out.println(" inside the getEncodedPassword method cus");

        return passwordEncoder.encode(password);

    }

    @Override
    public Optional<User> getByMail(String mail) {
     User user=   userRepository.findByEmail(mail);
     if(user==null){
         return Optional.empty();
     }
        return  Optional.of(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
