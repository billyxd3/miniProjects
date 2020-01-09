package com.itacademy.softserve.dao.filter;

import com.itacademy.softserve.constant.Statuses;
import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.List;

public class TaskFilter {
    public static enum Filters {
        FILTER_BY_OWNER("SELECT TaskID, Assignee, Owner, Description, CreationDate," +
                " Deadline, StatusID FROM tasks WHERE Assignee = ? AND Owner = ? AND NOT StatusID = ?;"),
        FILTER_BY_DATE("SELECT TaskID, Assignee, Owner, Description, CreationDate," +
                " Deadline, StatusID FROM tasks WHERE Assignee = ? AND (CreationDate BETWEEN ? AND ?) AND NOT StatusID = ?;"),
        FILTER_BY_STATUS("SELECT TaskID, Assignee, Owner, Description," +
                " CreationDate, Deadline, StatusID FROM tasks WHERE Assignee = ?  AND StatusID = ?;");

        private String query;

        private Filters(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }

    public List<Task> filterByOwner(InstanceBuilder<Task> builder, Long assigneeId, Long ownerId, Integer statusId) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_OWNER.getQuery(), builder, assigneeId, ownerId, statusId);
    }

    public List<Task> filterByDate(InstanceBuilder<Task> builder, Object... dates) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_DATE.getQuery(), builder, dates);
    }

    public List<Task> filterByStatus(InstanceBuilder<Task> builder, Long userId, Integer statusId) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_STATUS.getQuery(), builder, userId, statusId);
    }

}

