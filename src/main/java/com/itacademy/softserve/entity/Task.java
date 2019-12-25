package com.itacademy.softserve.entity;

import java.util.Date;
import java.util.Objects;

public class Task extends Entity {
    private User assignee;
    private User owner;
    private String taskDescription;
    private Date creationDate;
    private Date deadline;
    private Integer statusID;

    public Task() {
    }

    public Task(User assignee, User owner, String taskDescription,
                Date creationDate, Date deadline, Integer statusID) {
        this.assignee = assignee;
        this.owner = owner;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.statusID = statusID;
    }

    public Task(Long id, User assignee, User owner, String taskDescription,
                Date creationDate, Date deadline, Integer statusID) {
        super(id);
        this.assignee = assignee;
        this.owner = owner;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.statusID = statusID;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

        if (!Objects.equals(assignee, task.assignee)) return false;
        if (!Objects.equals(owner, task.owner)) return false;
        if (!Objects.equals(taskDescription, task.taskDescription))
            return false;
        if (!Objects.equals(creationDate, task.creationDate)) return false;
        if (!Objects.equals(deadline, task.deadline)) return false;
        return Objects.equals(statusID, task.statusID);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (assignee != null ? assignee.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (statusID != null ? statusID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "assignee=" + assignee +
                ", owner=" + owner +
                ", taskDescription='" + taskDescription + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                ", statusID=" + statusID +
                '}';
    }
}
