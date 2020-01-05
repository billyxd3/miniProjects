package com.itacademy.softserve.dto;

import java.util.Date;

public class TaskDto {
    private Long taskID;
    private String assignee;
    private String owner;
    private String description;
    private Date creationDate;
    private Date deadline;
    private String status;

    public TaskDto() {
    }

    public TaskDto(String assignee, String owner, String Description, Date creationDate, Date deadline, String status) {
        this.assignee = assignee;
        this.owner = owner;
        this.description = Description;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.status = status;
    }

    public TaskDto(Long taskID, String assignee, String owner, String Description,
                   Date creationDate, Date deadline, String status) {
        this.taskID = taskID;
        this.assignee = assignee;
        this.owner = owner;
        this.description = Description;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
