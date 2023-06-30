package com.dextris.controller;

import com.dextris.entity.User;
import com.dextris.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Optional;

@RestController

public class UserController {

    @Autowired
    private UserServiceImpl userService;

    public UserController() {

        System.out.println(this
                .getClass().getSimpleName());

    }

    public UserController(UserServiceImpl userService) {
        System.out.println(" this is controller" + this
                .getClass().getSimpleName());
        this.userService = userService;
    }
    @PostConstruct
    public void initRolesAndUser() {
        System.out.println(" inside the initRolesAndUser cus");

        userService.initRolesAndUser();


    }
    @PostMapping( {"/createNewUser"})
    public User createNewUser(@RequestBody User user) throws IOException {

        Optional<User> user1 = userService.getByMail(user.getEmail());
        System.out.println(user.getEmail());
        if (user1.isPresent()) {

            return null;
        } else {

            // this.userService.sendWelcomeEmail(user.getEmail(), "Thank for Register with Dextris Tech service We Are Happy to Meet you  ", "WELCOME TO DEXTRIS");


            return userService.validateAndCreateNewUser(user);


        }
    }
    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        System.out.println(" inside the forAdmin cus today");



        return "for adi";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser() {
        System.out.println(" inside the forUser cus");


        return "for user" ;
    }
}
