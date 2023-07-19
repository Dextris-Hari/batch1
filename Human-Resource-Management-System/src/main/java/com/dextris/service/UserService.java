package com.dextris.service;

import com.dextris.entity.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User validateAndCreateNewUser(User user ) throws IOException;
    default void initRolesAndUser() {


    }

    default Optional<User> getByMail(String mail) {


        return Optional.empty();
    }
    default List<User> getAllUsers(){

        return null;
    }

    default   void sendCredential(User user) {

    }
    public default void updateOtpDateAndTimeByMail(Integer otp, String mail, LocalTime time, LocalDate date, User dto) {

    }
    Boolean resetPassword(String email, String newPassword, Integer otp, User user, String conformPassword);

}
