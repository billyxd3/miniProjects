package com.softserve.dto;

import com.softserve.annotation.Column;
import com.softserve.annotation.Table;

import java.util.Date;

@Table(name = "checks")
public class Check {

    @Column(name = "id")
    private int id;
    @Column(name = "date_of_beginning")
    private Date date;

    public Check(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
