package com.squaregames.users.dao;

import com.squaregames.users.entity.UserEntity;
import com.squaregames.users.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserDao implements UserDao {

    private final UserRepository repository;

    public JpaUserDao(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(UserEntity user) {
        repository.save(user);
    }

    @Override
    public Optional<UserEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);
    }
}