package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.User;

public class UserDao extends ADaoCrud<User> {

    @Override
    protected void init() {
        for(User.UserEntityQueries userEntityQueries : User.UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getQuery(), userEntityQueries);
        }
    }

    @Override
    protected Object[] getFields(User entity) {
        return new Object[0];
    }
}
