package com.dextris.dextris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class JwtResponse {


    private User user;
    private String jwtToken;

    public JwtResponse(User user, String jwtToken) {
        System.out.println(" inside the para "+this
                .getClass().getSimpleName());
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
