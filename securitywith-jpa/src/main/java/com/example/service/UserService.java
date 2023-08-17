package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void initRolesAndUser() {

        User user= new User();
        user.setUserName("Manoj");
        user.setRole("ADMIN,USER");
        user.setPassword("123");
        user.setActive(true);
         User user1=userRepository.save(user);
        System.out.println(user1);

    }


}
