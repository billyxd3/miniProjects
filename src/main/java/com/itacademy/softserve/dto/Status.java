package com.itacademy.softserve.dto;

public class Status {
    private Integer id;
    private String status;

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }

    public Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
