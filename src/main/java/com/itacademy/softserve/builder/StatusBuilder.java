package com.itacademy.softserve.builder;

import com.itacademy.softserve.entity.Status;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusBuilder implements InstanceBuilder<Status> {
    @Override
    public Status createInstance(ResultSet resultSet) {
        Status status = new Status();
        try {
            status.setId(resultSet.getLong("StatusID"));
            status.setName(resultSet.getString("Name"));
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
