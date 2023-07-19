package com.dextris.dextris.controller;

import com.dextris.dextris.entity.User;
import com.dextris.dextris.service.UserService;
import com.dextris.dextris.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController

public class UserController {
    @Autowired
    private UserServiceImpl userService;
    public UserController( ) {
        System.out.println(this
                .getClass().getSimpleName());

    }

    public UserController(UserServiceImpl userService) {
        System.out.println(" this is controller"+this
                .getClass().getSimpleName());
        this.userService = userService;
    }

    @PostConstruct
    public  void initRolesAndUser(){
        System.out.println( " inside the initRolesAndUser cus");

        userService.initRolesAndUser();

    }

    @PostMapping({"/createNewUser"})
    public User createNewUser(@RequestBody User user) throws MessagingException, IOException {
        System.out.println("inside the createNewUser cus");
      Optional<User> user1= userService.getByMail(user.getEmail());
        System.out.println(user.getEmail());
      if(user1.isPresent()){
          System.out.println("user is allready exist");
          return  null;
      }
      else {

          this.userService.sendWelcomeEmail(user.getEmail(), "Thank for Register with Dextris Tech service We Are Happy to Meet you  ", "WELCOME TO DEXTRIS");
//    this.userService.sendMailWithAttachment(user.getEmail(),"hey this is your resume check once all is fine",
          //    "WITH ATTACHMENT","C:\\Users\\Dell\\Desktop\\manoj h j.pdf");
          return userService.validateAndCreateNewUser(user);
      }
    }
    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        System.out.println(" inside the forAdmin cus");


        return " this url is only for the admin";
    }
    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        System.out.println(" inside the forUser cus");


        return " this url is only for the user";
    }

}
