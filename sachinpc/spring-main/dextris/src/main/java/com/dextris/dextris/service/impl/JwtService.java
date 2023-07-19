package com.dextris.dextris.service.impl;

import com.dextris.dextris.entity.JwtRequest;
import com.dextris.dextris.entity.JwtResponse;
import com.dextris.dextris.entity.User;
import com.dextris.dextris.repository.UserRepository;
import com.dextris.dextris.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtService() {
        System.out.println(
                this.getClass().getSimpleName());

    }
    public JwtService(UserRepository userRepository, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        System.out.println(" inside the para cos"+this.getClass().getSimpleName());
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        System.out.println(" inside createJwtToken method cus");


        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);
        final UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        User user = userRepository.findById(userName).get();
        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("inside the loadUserByUserName method cus");
        User user = userRepository.findById(username).get();
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getNewPassword(), getAuthorities(user));
        } else {
            throw new UsernameNotFoundException("user name is not valid");
        }


    }

    private Set getAuthorities(User user) {
        System.out.println(" inside the getAuthorities method cus");

        Set<SimpleGrantedAuthority> authorities = new HashSet();
        user.getRole().forEach(role -> {

            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        System.out.println("aithade");
        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        System.out.println(" inside the authenticate method cus");
        try {
            System.out.println("8527");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,
                    userPassword));
        } catch (DisabledException exception) {
            throw new Exception("user is desabled");
        } catch (BadCredentialsException exception) {

            throw new Exception("bad credential from user");
        }


    }
}
