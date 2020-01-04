package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.User;
import com.itacademy.softserve.exception.NotFoundException;
import com.itacademy.softserve.exception.NotSaveException;
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
    public boolean login(UserDto userDto) {
        User user = userDao.getByFields(new UserBuilder(), userDto.getName()).get(0);
        if(user != null) {
            return user.getName().equals(userDto.getName())
                    && user.getPassword().equals(userDto.getPassword());
        } else {
            throw new NotFoundException("Don`t login");
        }
    }

    @Override
    public boolean save(UserDto userDto) {
        if(userDao.getByFields(new UserBuilder(), userDto.getName()).isEmpty()) {
            return userDao.insert(new User(userDto.getName(), userDto.getPassword()));
        } else {
            throw new NotSaveException("Don`t save");
        }
    }

    public static void main(String[] args) {
        UserDto userDto = new UserDto("rr", "gfg");
        new UserServiceImpl().save(userDto);
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
