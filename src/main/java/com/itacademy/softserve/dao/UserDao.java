package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements Crud<User> {
    @Override
    public boolean create(User createdObject) {
        return false;
    }

    @Override
    public Optional<User> findByID(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean update(User objectToUpdate) {
        return false;
    }

    @Override
    public boolean deleteByID(long id) {
        return false;
    }
}
