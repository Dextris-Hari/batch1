package com.dextris.service;

import com.dextris.entity.User;

import java.io.IOException;
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
}
