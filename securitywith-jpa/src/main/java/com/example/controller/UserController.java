package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUser(){
        System.out.println("manoj is in post constructor");

        userService.initRolesAndUser();

    }



    @GetMapping("/")
    public  String home(){


        return  ("<h1>Welcome</h1>");
    }
    @GetMapping("/admin")
    public  String admin(){


        return  ("<h1>Welcome admin</h1>");
    }
    @GetMapping("/user")
    public  String user(){


        return  ("<h1>Welcome user</h1>");
    }



}
