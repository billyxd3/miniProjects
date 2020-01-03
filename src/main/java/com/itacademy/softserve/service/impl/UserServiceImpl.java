package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.User;
import com.itacademy.softserve.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDao();
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean save(UserDto userDto) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
