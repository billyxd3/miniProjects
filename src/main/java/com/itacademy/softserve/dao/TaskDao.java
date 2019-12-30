package com.itacademy.softserve.dao;

import com.itacademy.softserve.builder.InstanceBuilder;
import com.itacademy.softserve.builder.TaskBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
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

    public List<Task> getByRegex(InstanceBuilder<Task> builder, String regex) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, sqlQueries.get(SqlQueries.GET_BY_REGEX).toString(), builder, regex);
    }

    public static void main(String[] args) {
        TaskDao taskDao = new TaskDao();
        Task task = taskDao.getByID(new TaskBuilder(),3L);
        List<Task> list = taskDao.getByRegex(new TaskBuilder(), "write dao");
       // System.out.println();
        list.forEach(System.out::println);
    }

}
