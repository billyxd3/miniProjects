package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.User;

public class UserDao extends DaoCrudA<User> {

    @Override
    protected void init() {
        for(User.UserEntityQueries userEntityQueries : User.UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getQuery(), userEntityQueries);
        }
    }

    @Override
    protected Object[] getFields(User entity) {
        Object[] fields = new Object[3];
        fields[0] = entity.getId();
        fields[1] = entity.getName();
        fields[2] = entity.getPassword();
        return fields;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.updateByField("Andy", "333", "Andy"));
    }
}
