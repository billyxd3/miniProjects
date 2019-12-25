package com.itacademy.softserve.entity;

import java.util.Objects;

public class Status extends Entity {
    private String name;

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public Status(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Status status = (Status) o;
        return name.equals(status.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "name='" + name + '\'' +
                '}';
    }
}
