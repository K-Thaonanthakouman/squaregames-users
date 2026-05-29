package com.squaregames.users.dao;

import com.squaregames.users.entity.UserEntity;

import java.util.Optional;

public interface UserDao {
    void save(UserEntity user);
    Optional<UserEntity> findById(String id);
    void delete(String id);
    boolean exists(String id);
}