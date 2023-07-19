package com.dextris.Resttemplteconsume.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@jakarta.persistence.Entity
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String name;
    private String eMail;

    public User() {
    }

    public User( String name, String eMail) {

        this.name = name;
        this.eMail = eMail;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
