package com.itacademy.softserve.dto;

import java.util.Date;

public class Task {
    private Long taskID;
    private String assignee;
    private String owner;
    private String taskDescription;
    private Date creationDate;
    private Date deadline;
    private Integer statusID;

    public Task() {
    }

    public Task(String assignee, String owner, String taskDescription, Date creationDate, Date deadline, Integer statusID) {
        this.assignee = assignee;
        this.owner = owner;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.statusID = statusID;
    }

    public Task(Long taskID, String assignee, String owner, String taskDescription,
                Date creationDate, Date deadline, Integer statusID) {
        this.taskID = taskID;
        this.assignee = assignee;
        this.owner = owner;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.statusID = statusID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
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

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }
}
