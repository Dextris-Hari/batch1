package com.dextris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userName;
    private Date dateOfBirth;

    private String gender;

    private String email;

    private Long phoneNumber;

    private String newPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = {


            @JoinColumn(name = "USER_ID")
    },
            inverseJoinColumns = {


                    @JoinColumn(name = "ROLE_ID")
            }


    )

    private Set<Role> role;


    private String status;
    private String conformPassword;
    private Integer count;
    private Integer otp;
    private LocalDate date;
    private LocalTime time;
    private String address;

}
