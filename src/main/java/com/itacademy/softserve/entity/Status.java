package com.itacademy.softserve.entity;

import java.util.Objects;

public class Status extends Entity {
    public static enum StatusEntityQueries {
        GET_BY_ID(SqlQueries.GET_BY_ID, ""),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, ""),
        INSERT(SqlQueries.INSERT, ""),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, ""),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, ""),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, ""),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "");

        private SqlQueries sqlQueries;
        private String query;

        private StatusEntityQueries(SqlQueries sqlQueries, String query) {
            this.sqlQueries = sqlQueries;
            this.query = query;
        }

        public SqlQueries getQuery() {
            return sqlQueries;
        }

        @Override
        public String toString() {
            return query;
        }
    }
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
