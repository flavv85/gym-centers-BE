package com.flavius.gymcenter.impl;

import com.flavius.gymcenter.dao.UserDao;
import com.flavius.gymcenter.model.User;
import com.flavius.gymcenter.service.UserService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Component
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User editUser(User user, long id) {
        User existsUser = userDao.findById(id).orElse(null);
        existsUser.setUsername(user.getUsername());
        existsUser.setPassword(user.getPassword());
        existsUser.setAdmin(user.isAdmin());
        return userDao.save(existsUser);
    }

    @Override
    public User findUserById(long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional<User> users = userDao.findByUsername(username);
        return users;
    }

    @Override
    public void deleteUser(long id) {
        User existsUser = userDao.findById(id).orElse(null);
        userDao.delete(existsUser);
    }
}
