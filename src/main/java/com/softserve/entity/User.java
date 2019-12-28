package com.softserve.entity;

import java.util.Objects;

public class User {
    public static enum UserEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, first_name, last_name, email, password, photo FROM users WHERE id = ?"),
        UDPATE(SqlQueries.UPDATE, "UPDATE users SET first_name = ?, last_name = ?, email = ?, " +
                "password = ?, photo =? WHERE id = %s;");

        private SqlQueries sqlQuery;
        private String query;

        UserEntityQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        public String getQuery() {
            return query;
        }
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String photo;
    private Long categoryId;
    private Long recordId;
    private Long planedOutcomeId;

    public User(Long id, String firstName, String lastName, String email, String password, String photo, Long categoryId, Long recordId, Long planedOutcomeId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.categoryId = categoryId;
        this.recordId = recordId;
        this.planedOutcomeId = planedOutcomeId;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getPlanedOutcomeId() {
        return planedOutcomeId;
    }

    public void setPlanedOutcomeId(Long planedOutcomeId) {
        this.planedOutcomeId = planedOutcomeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(photo, user.photo) &&
                Objects.equals(categoryId, user.categoryId) &&
                Objects.equals(recordId, user.recordId) &&
                Objects.equals(planedOutcomeId, user.planedOutcomeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, photo, categoryId, recordId, planedOutcomeId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", categoryId=" + categoryId +
                ", recordId=" + recordId +
                ", planedOutcomeId=" + planedOutcomeId +
                '}';
    }
}