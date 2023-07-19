package com.dextris.dextris.service;

import com.dextris.dextris.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface UserService {


    User validateAndCreateNewUser(User user ) throws IOException;

    default void initRolesAndUser() {


    }

    /*default void sendEmail(String toMail, String body, String sub) {


    }*/

    default void sendMailWithAttachment(String toMail, String body, String sub, String attachment) throws MessagingException {


    }

    default Optional<User> getByMail(String mail) {


        return null;
    }

    public default void updateOtpDateAndTimeByMail(Integer otp, String mail, LocalTime time, LocalDate date, User dto) {

    }

    Boolean resetPassward(String email, String newPassword, Integer otp, User user, String conformPassword);
}
