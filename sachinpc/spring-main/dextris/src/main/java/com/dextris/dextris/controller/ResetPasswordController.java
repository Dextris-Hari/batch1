package com.dextris.dextris.controller;

import com.dextris.dextris.entity.User;
import com.dextris.dextris.repository.UserRepository;
import com.dextris.dextris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResetPasswordController {

@Autowired
    private UserService userService;
@Autowired
    private final UserRepository userRepository;

    public ResetPasswordController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/reset")
    public User resetPassword(@RequestBody User user) {
        if (user.getNewPassword().equals(user.getConformPassword())) {

            Boolean resetPassward =
                    userService.resetPassward(user.getEmail(), user.getNewPassword(), user.getOtp(), user, user.getConformPassword());


            if (resetPassward) {

                System.out.println(" password is reseted");
                return user;
            } else {

                System.out.println(" password is not reseted");
                return user;
            }

        } else {


            return user;
        }



    }
}
