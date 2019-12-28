package com.itacademy.softserve.entity;

import java.util.Date;
import java.util.Objects;

public class History extends Entity {
    public static enum HistoryEntityQueries {
        GET_BY_ID(SqlQueries.GET_BY_ID, ""),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, ""),
        GET_ALL(SqlQueries.GET_ALL, ""),
        INSERT(SqlQueries.INSERT, ""),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, ""),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, ""),
        DELETE_ALL(SqlQueries.DELETE_ALL, "");

        private SqlQueries sqlQueries;
        private String query;

        private HistoryEntityQueries(SqlQueries sqlQueries, String query) {
            this.sqlQueries = sqlQueries;
            this.query = query;
        }

        public SqlQueries getQuery() {
            return sqlQueries;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long taskID;
    private Date modifiedDate;
    private Integer statusID;

    public History() {
    }

    public History(Long taskID, Date modifiedDate, Integer statusID) {
        this.taskID = taskID;
        this.modifiedDate = modifiedDate;
        this.statusID = statusID;
    }

    public History(Long id, Long taskID, Date modifiedDate, Integer statusID) {
        super(id);
        this.taskID = taskID;
        this.modifiedDate = modifiedDate;
        this.statusID = statusID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        History history = (History) o;
        if (!Objects.equals(taskID, history.taskID)) return false;
        return Objects.equals(statusID, history.statusID);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (taskID != null ? taskID.hashCode() : 0);
        result = 31 * result + (statusID != null ? statusID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "History{" +
                "ID=" + getId() +
                "taskID=" + taskID +
                ", modifiedDate=" + modifiedDate +
                ", statusID=" + statusID +
                '}';
    }
}
