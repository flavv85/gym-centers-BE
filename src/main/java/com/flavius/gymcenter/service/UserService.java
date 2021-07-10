package com.flavius.gymcenter.service;

import com.flavius.gymcenter.model.User;

import java.util.Optional;

public interface UserService {
    User addUser(User user);

    User editUser(User user, long id);

    User findUserById(long id);

    Optional<User> findUserByUsername(String username);

    void deleteUser(long id);
}
