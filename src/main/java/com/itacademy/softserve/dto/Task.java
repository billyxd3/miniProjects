package com.itacademy.softserve.dto;

import java.util.Date;

public class Task {
    private Integer id;
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

    public Task(Integer id, Integer assigneeID, Integer ownerID, String taskDescription,
                Date creationDate, Date deadline, Integer statusID) {
        this.id = id;
        this.assigneeID = assigneeID;
        this.ownerID = ownerID;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.statusID = statusID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
