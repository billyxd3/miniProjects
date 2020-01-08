package com.itacademy.softserve.dto.mapper;

import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.Entity;
import com.itacademy.softserve.entity.User;

public class UserDtoMapper implements DtoMapper<UserDto> {
    @Override
    public UserDto mapFromEntityToDto(Entity entity) {
        User user = (User) entity;
        return new UserDto(user.getName(), user.getPassword());
    }
}
