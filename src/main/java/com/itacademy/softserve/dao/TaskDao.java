package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.Task;

import java.util.List;
import java.util.Optional;

public class TaskDao extends ADaoCrud<Task> {

    @Override
    protected void init() {
        for(Task.TaskEntityQueries taskEntityQueries : Task.TaskEntityQueries.values()) {
            sqlQueries.put(taskEntityQueries.getQuery(), taskEntityQueries);
        }
    }

    @Override
    protected Object[] getFields(Task entity) {
        Object[] fields = new Object[7];
        fields[0] = entity.getId();
        fields[1] = entity.getAssigneeID();
        fields[2] = entity.getOwnerID();
        fields[3] = entity.getDescription();
        fields[4] = entity.getCreationDate();
        fields[5] = entity.getDeadline();
        fields[6] = entity.getStatusID();
        return fields;
    }

}
