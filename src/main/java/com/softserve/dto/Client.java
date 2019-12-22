package com.softserve.dto;

import com.softserve.annotation.Column;
import com.softserve.annotation.Table;

@Table(name = "clients")
public class Client {

    @Column(name = "id")
    private int id;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "tel",length = 11)
    private int tel;

    public Client(int id, String name, int tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel=" + tel +
                '}';
    }
}
