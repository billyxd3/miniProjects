package com.itacademy.softserve.dao;

import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.dao.builder.TaskBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class TaskDao extends DaoCrudA<Task> {

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

    public List<Task> getByRegex(InstanceBuilder<Task> builder, Long userId, Long statusId, String regex) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        StringBuilder query = new StringBuilder(sqlQueries.get(SqlQueries.GET_BY_REGEX).toString())
                .append("'%")
                .append(regex)
                .append("%';");

        return CrudUtils.getEntityList(connection, query.toString(), builder, userId, statusId);
    }

//    public static void main(String[] args) {
//        System.out.println(new TaskDao().getByRegex(new TaskBuilder(), 1L, 5L, "to11").get(0));
//    }

    @Override
    public boolean updateByField(Object... fieldsValues) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(),
                fieldsValues[0], fieldsValues[1], fieldsValues[2], fieldsValues[3]);
        int status = CrudUtils.update(connection, query, fieldsValues);
        return status > 0;
    }
}
