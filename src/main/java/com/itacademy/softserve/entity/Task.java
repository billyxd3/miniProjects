package com.itacademy.softserve.entity;

import java.util.Date;
import java.util.Objects;

public class Task extends Entity {
    public static enum TaskEntityQueries {
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT TaskID, Assignee, Owner, Description, CreationDate," +
                " Deadline, StatusID FROM tasks WHERE TaskID = ?;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT TaskID, Assignee, Owner, Description," +
                " CreationDate, Deadline, StatusID FROM tasks WHERE StatusID = ?;"),
        GET_BY_REGEX(SqlQueries.GET_BY_REGEX, "SELECT TaskID, Assignee, Owner, Description," +
                " CreationDate, Deadline, StatusID FROM tasks WHERE Description LIKE '%?%';"),
        INSERT(SqlQueries.INSERT, "INSERT INTO tasks (Assignee, Owner, Description, CreationDate, Deadline, StatusID) " +
                "VALUES (?, ?, ?, ?, ?, ?);"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE tasks SET StatusID = ? WHERE TaskID = ?;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE tasks SET ? = ? WHERE ? = ?;");

        private SqlQueries sqlQueries;
        private String query;

        private TaskEntityQueries(SqlQueries sqlQueries, String query) {
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

    private Integer assigneeID;
    private Integer ownerID;
    private String description;
    private Date creationDate;
    private Date deadline;
    private Integer statusID;

    public Task() {
    }

    public Task(Integer assigneeID, Integer ownerID, String description,
                Date creationDate, Date deadline, Integer statusID) {
        this.assigneeID = assigneeID;
        this.ownerID = ownerID;
        this.description = description;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.statusID = statusID;
    }

    public Task(Long id, Integer assigneeID, Integer ownerID, String description,
                Date creationDate, Date deadline, Integer statusID) {
        super(id);
        this.assigneeID = assigneeID;
        this.ownerID = ownerID;
        this.description = description;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.statusID = statusID;
    }

    public Integer getAssigneeID() {
        return assigneeID;
    }

    public void setAssigneeID(Integer assigneeID) {
        this.assigneeID = assigneeID;
    }

    public Integer getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

        Task task = (Task) o;

        if (!Objects.equals(assigneeID, task.assigneeID)) return false;
        if (!Objects.equals(ownerID, task.ownerID)) return false;
        if (!Objects.equals(description, task.description))
            return false;
        if (!Objects.equals(creationDate, task.creationDate)) return false;
        if (!Objects.equals(deadline, task.deadline)) return false;
        return Objects.equals(statusID, task.statusID);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (assigneeID != null ? assigneeID.hashCode() : 0);
        result = 31 * result + (ownerID != null ? ownerID.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (statusID != null ? statusID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id = " + getId() +
                ", assignee=" + assigneeID +
                ", owner=" + ownerID +
                ", taskDescription='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                ", statusID=" + statusID +
                '}';
    }
}
