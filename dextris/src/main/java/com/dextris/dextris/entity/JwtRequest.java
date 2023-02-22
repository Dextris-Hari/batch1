package com.dextris.dextris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class JwtRequest {
    private String userName;
    private String userPassword;

    public JwtRequest(String userName, String userPassword) {
        System.out.println(" this is inside the para "+this.getClass().getSimpleName());
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
