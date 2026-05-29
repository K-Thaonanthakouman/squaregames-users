package com.squaregames.users.service;

import com.squaregames.users.dao.UserDao;
import com.squaregames.users.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity createUser(String username, String email) {
        UserEntity user = new UserEntity();
        user.id = UUID.randomUUID().toString();
        user.username = username;
        user.email = email;
        userDao.save(user);
        return user;
    }

    @Override
    public Optional<UserEntity> getUser(String id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUser(String id) {
        userDao.delete(id);
    }

    @Override
    public boolean isValid(String id) {
        return userDao.exists(id);
    }
}