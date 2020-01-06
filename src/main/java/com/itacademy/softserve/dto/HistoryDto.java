package com.itacademy.softserve.dto;

import java.util.Date;

public class HistoryDto {
    private Long id;
    private String task;
    private Date modifiedDate;
    private String status;

    public HistoryDto() {
    }

    public HistoryDto(String task, Date modifiedDate, String status) {
        this.task = task;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public HistoryDto(Long id, String task, Date modifiedDate, String status) {
        this.id = id;
        this.task = task;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
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
