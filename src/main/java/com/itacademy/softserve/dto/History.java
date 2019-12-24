package com.itacademy.softserve.dto;

import java.util.Date;

public class History {
    private Integer id;
    private Task task;
    private Date modifiedDate;
    private String status;

    public  History() {
    }

    public History(Task task, Date modifiedDate, String status) {
        this.task = task;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public History(Integer id, Task task, Date modifiedDate, String status) {
        this.id = id;
        this.task = task;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
