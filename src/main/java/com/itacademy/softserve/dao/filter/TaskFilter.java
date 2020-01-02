package com.itacademy.softserve.dao.filter;

import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.List;

public class TaskFilter {
    public static enum Filters {
        FILTER_BY_ASSIGNEE("SELECT TaskID, Assignee, Owner, Description, CreationDate," +
                " Deadline, StatusID FROM tasks WHERE Assignee = ?;"),
        FILTER_BY_OWNER("SELECT TaskID, Assignee, Owner, Description, CreationDate," +
                " Deadline, StatusID FROM tasks WHERE Owner = ?;"),
        FILTER_BY_DATE("SELECT TaskID, Assignee, Owner, Description, CreationDate," +
                " Deadline, StatusID FROM tasks WHERE CreationDate BETWEEN ? AND ?;"),
        FILTER_BY_STATUS("SELECT TaskID, Assignee, Owner, Description," +
                " CreationDate, Deadline, StatusID FROM tasks WHERE StatusID = ?;");

        private String query;

        private Filters(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }

    public List<Task> filterByAssignee(InstanceBuilder<Task> builder, Long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_ASSIGNEE.getQuery(), builder, id);
    }

    public List<Task> filterByOwner(InstanceBuilder<Task> builder, Long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_OWNER.getQuery(), builder, id);
    }

    public List<Task> filterByDate(InstanceBuilder<Task> builder, Object... dates) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_DATE.getQuery(), builder, dates);
    }

    public List<Task> filterByStatus(InstanceBuilder<Task> builder, Integer id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_STATUS.getQuery(), builder, id);
    }

}

