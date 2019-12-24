package com.itacademy.softserve.dto;

import java.util.Date;

public class Task {
    private String assignee;
    private String owner;
    private String taskDescription;
    private Date creationDate;
    private Date deadline;
    private String status;

    public Task() {
    }

    public Task(String assignee, String owner, String taskDescription, Date creationDate, Date deadline, String status) {
        this.assignee = assignee;
        this.owner = owner;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.status = status;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
