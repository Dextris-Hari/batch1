package com.dextris.dextris.controller;

import com.dextris.dextris.entity.JwtRequest;
import com.dextris.dextris.entity.JwtResponse;
import com.dextris.dextris.entity.User;
import com.dextris.dextris.repository.UserRepository;
import com.dextris.dextris.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    private Integer count = 0;



    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;

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
        JwtResponse jwtResponse= jwtService.createJwtToken(jwtRequest);
          User user=           userRepository.findById(jwtResponse.getUser().getUserName()).get();
        if(jwtResponse!=null){
            System.out.println(jwtResponse.getStatus()+"🐗🐗🐗🐗🐗🐗🐗");
            if(user.getStatus().equals("blocked")){
                System.out.println("your account is blocked");

                return null;

            }else {
                System.out.println(" your registration is complited");
                return jwtResponse;

            }

        }
        else{
            this.count++;
            if(count==4) {
                System.out.println("your account is blocked");
            }
            return null;

        }






    }
}
