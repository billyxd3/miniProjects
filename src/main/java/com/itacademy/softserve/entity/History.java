package com.itacademy.softserve.entity;

import java.util.Date;
import java.util.Objects;

public class History extends Entity {
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
