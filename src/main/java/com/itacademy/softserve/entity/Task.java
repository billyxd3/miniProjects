package com.itacademy.softserve.entity;

import java.util.Date;
import java.util.Objects;

public class Task extends Entity {
    private Integer assigneeID;
    private Integer ownerID;
    private String taskDescription;
    private Date creationDate;
    private Date deadline;
    private Integer statusID;

    public Task() {
    }

    public Task(Integer assigneeID, Integer ownerID, String taskDescription,
                Date creationDate, Date deadline, Integer statusID) {
        this.assigneeID = assigneeID;
        this.ownerID = ownerID;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.statusID = statusID;
    }

    public Task(Long id, Integer assigneeID, Integer ownerID, String taskDescription,
                Date creationDate, Date deadline, Integer statusID) {
        super(id);
        this.assigneeID = assigneeID;
        this.ownerID = ownerID;
        this.taskDescription = taskDescription;
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

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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
        if (!Objects.equals(taskDescription, task.taskDescription))
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
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (statusID != null ? statusID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "assignee=" + assigneeID +
                ", owner=" + ownerID +
                ", taskDescription='" + taskDescription + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                ", statusID=" + statusID +
                '}';
    }
}
