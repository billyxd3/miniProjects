package com.itacademy.softserve.builder;

import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskBuilder implements InstanceBuilder<Task> {
    @Override
    public Task createInstance(ResultSet resultSet) {
        Task task = new Task();
        try {
            task.setId(resultSet.getLong("TaskID"));
            task.setAssigneeID(resultSet.getInt("Assignee"));
            task.setOwnerID(resultSet.getInt("Owner"));
            task.setDescription(resultSet.getString("Description"));
            task.setCreationDate(resultSet.getDate("CreationDate"));
            task.setDeadline(resultSet.getDate("Deadline"));
            task.setStatusID(resultSet.getInt("StatusID"));
            return task;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
