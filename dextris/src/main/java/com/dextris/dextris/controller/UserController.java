package com.dextris.dextris.controller;

import com.dextris.dextris.entity.Attachment;
import com.dextris.dextris.entity.EMail;
import com.dextris.dextris.entity.User;
import com.dextris.dextris.service.AttachmentService;
import com.dextris.dextris.service.UserService;
import com.dextris.dextris.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.validation.constraints.Email;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController

public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AttachmentService attachmentService;



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
    public User createNewUser(@RequestBody User user) throws MessagingException, IOException {

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
