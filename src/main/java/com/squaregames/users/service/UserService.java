package com.squaregames.users.service;

import com.squaregames.users.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    UserEntity createUser(String username, String email, String password);
    Optional<UserEntity> getUser(String id);
    void deleteUser(String id);
    boolean isValid(String id);
}