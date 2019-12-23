package com.itacademy.softserve.dto;

import java.util.Date;

public class History {
    private Integer id;
    private Integer taskID;
    private Date modifiedDate;
    private Integer statusID;

    public  History() {
    }

    public History(Integer taskID, Date modifiedDate, Integer statusID) {
        this.taskID = taskID;
        this.modifiedDate = modifiedDate;
        this.statusID = statusID;
    }

    public History(Integer id, Integer taskID, Date modifiedDate, Integer statusID) {
        this.id = id;
        this.taskID = taskID;
        this.modifiedDate = modifiedDate;
        this.statusID = statusID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
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
}
