package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean login(UserDto userDto);

    boolean save(UserDto userDto);

    boolean update(User user);

    Optional<User> getById(Long id);

    Optional<User> getByName(String name);

    List<UserDto> getAll();
}
