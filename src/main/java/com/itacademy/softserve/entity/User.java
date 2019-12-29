package com.itacademy.softserve.entity;

import java.util.Objects;

public class User extends Entity {
    public static enum UserEntityQueries {
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT UserID, Name, Password FROM users WHERE UserID = ?;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT UserID, Name, Password FROM users WHERE Name = ?;"),
        INSERT(SqlQueries.INSERT, "INSERT INTO users (Name, Password) VALUES (?, ?);"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET Name = ?, Password = ? WHERE UserID = ?;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET Name = ?, Password = ? WHERE Name = ?;");

        private SqlQueries sqlQueries;
        private String query;

        private UserEntityQueries(SqlQueries sqlQueries, String query) {
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
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(Long id, String name, String password) {
        super(id);
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
