package com.dextris.dextris.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import org.springframework.scheduling.quartz.LocalDataSourceJobStore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;


@Entity


public class User {
    public User() {
    }


    @Id
    private String userName;


    private String lastName;

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


    private Date dateOfBirth;


    private String fileName;

    private String status;
    private String conformPassword;
    private Integer count;
    private Integer otp;
    private LocalDate date;
    private LocalTime time;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConformPassword() {
        return conformPassword;
    }

    public void setConformPassword(String conformPassword) {
        this.conformPassword = conformPassword;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", newPassword='" + newPassword + '\'' +
                ", role=" + role +
                ", dateOfBirth=" + dateOfBirth +
                ", fileName=" + fileName +
                ", status='" + status + '\'' +
                ", conformPassword='" + conformPassword + '\'' +
                ", count=" + count +
                ", otp=" + otp +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    public User(String userName, String lastName, String email, Long phoneNumber, String newPassword, Set<Role> role, Date dateOfBirth, String fileName, String status, String conformPassword, Integer count, Integer otp, LocalDate date, LocalTime time) {
        this.userName = userName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.newPassword = newPassword;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.fileName = fileName;
        this.status = status;
        this.conformPassword = conformPassword;
        this.count = count;
        this.otp = otp;
        this.date = date;
        this.time = time;
    }
}
