package com.dextris.dextris.controller;

import com.dextris.dextris.entity.User;
import com.dextris.dextris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ForgotPasswordController {
    @Autowired
   private  UserService userService;




    @PostMapping("/forgot")
    User forgetPassward( @RequestBody User user) {
        System.out.println("💖💖💖💖💖💖💖💖💖💖💖💖💖💖💖💖");
        userService.updateOtpDateAndTimeByMail(user.getOtp(), user.getEmail(),
                user.getTime(), user.getDate(), user);

            System.out.println(" check our mail id otp is sended");

           return user;

        }



   /* @PostMapping
    String onPostForgetPassward(User user) {

        return this.forgetPassward(user);
    }*/
}
