package com.dextris.Resttemplteconsume.Controller;

import com.dextris.Resttemplteconsume.Repository.UserRepository;
import com.dextris.Resttemplteconsume.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/m")
    public User save(@Valid @RequestBody com.dextris.Resttemplteconsume.entity.User user){


        return userRepository.save(user);
    }
    @GetMapping
    public List<User> getAllUser(){

        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id){

        return userRepository.findById(id).get();
    }
    @PutMapping("/{id}")
    public User updateById(@Valid @RequestBody User user,@PathVariable int id){
        System.out.println("manoj");

        User user1=  userRepository.findById(id).get();
      user1.seteMail(user.geteMail());
        user1.setName(user.getName());

        return userRepository.save(user1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById( @PathVariable int id){
        System.out.println("manoj");
        User user1=  userRepository.findById(id).get();
     userRepository.delete(user1);
        return ResponseEntity.ok().build();
    }
}
