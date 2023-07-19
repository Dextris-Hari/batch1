package com.dextris.dextris.controller;

import com.dextris.dextris.entity.JwtRequest;
import com.dextris.dextris.entity.JwtResponse;
import com.dextris.dextris.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {


    @Autowired
    private JwtService jwtService;
    public JwtController() {
        System.out.println(this.getClass().getSimpleName());

    }

    public JwtController(JwtService jwtService) {
        System.out.println(" inside the JwtController"+this.getClass().getSimpleName());
        this.jwtService = jwtService;
    }

    @PostMapping({"/Authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(" inside the createJwtToken cus");
        System.out.println(" this is controller");
        return jwtService.createJwtToken(jwtRequest);


    }
}
