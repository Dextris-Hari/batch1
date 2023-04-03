package com.dextris.dextris.controller;

import com.dextris.dextris.entity.EMail;
import com.dextris.dextris.service.UserService;
import com.dextris.dextris.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {
    @Autowired
    private UserService userService;


    @PostMapping("/send")
    private EMail sendMail(@RequestBody EMail eMail) throws MessagingException {
        System.out.println(this.userService + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000");

        System.out.println(eMail.getToMail());
        System.out.println(eMail.getAttachment());
        System.out.println(eMail.getBody());
        System.out.println(eMail.getSubject());
        this.userService.send(new EMail(eMail.getToMail(), eMail.getBody(), eMail.getAttachment(), eMail.getSubject()));
        System.out.println("❤️❤️❤️❤️❤️❤️");
        return new EMail();
    }
}
