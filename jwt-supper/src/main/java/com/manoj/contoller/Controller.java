package com.manoj.contoller;

import com.manoj.entity.JWTRequest;
import com.manoj.entity.JWTResponse;
import com.manoj.servce.MyUserServiceDetails;
import com.manoj.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class Controller {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserServiceDetails userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;


    @GetMapping("/man")
    public String getString(){


        return "(<h1>welcome</h1>)";
    }
    @PostMapping("/auth")
    public ResponseEntity getToken(@RequestBody JWTRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName()
                    , jwtRequest.getPassword()));
        }
        catch (BadCredentialsException badCredentialsException){

           throw new Exception(" bad credentioal",badCredentialsException);


        }
        final UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUserName());

        final  String token=jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JWTResponse(token));
    }
}
