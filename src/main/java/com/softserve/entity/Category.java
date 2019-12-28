package com.softserve.entity;

import java.util.Objects;

public class Category {
    public static enum CategoryEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO categories (title, color, description, financial_typeId) VALUES (?, ?, ?, ?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT title, color, description, financial_typeId, user_id FROM categories WHERE id = ?"),
        GET_ALL_BY_USER_ID(SqlQueries.GET_ALL_BY_USER_ID, "SELECT * FROM categories WHERE user_id = ?"),
        GET_ALL_BY_USER_ID_AND_FINANCIAL_TYPE(SqlQueries.GET_ALL_BY_USER_ID_AND_FINANCIAL_TYPE, "SELECT * FROM categories WHERE user_id = ? AND financial_type_id = ?"),
        UPDATE(SqlQueries.UPDATE, "UPDATE categories SET title = ?, color = ?, description = ?, financial_typeId = ? WHERE id = ?"),
        DELETE(SqlQueries.DELETE, "DELETE FROM categories WHERE id = ?");

        private SqlQueries sqlQuery;
        private String query;

        CategoryEntityQueries(SqlQueries sqlQuery, String query) {
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
    private String title;
    private String color;
    private String description;
    private Long userId;
    private Long financialTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFinancialTypeId() {
        return financialTypeId;
    }

    public void setFinancialTypeId(Long financialTypeId) {
        this.financialTypeId = financialTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(title, category.title) &&
                Objects.equals(color, category.color) &&
                Objects.equals(description, category.description) &&
                Objects.equals(userId, category.userId) &&
                Objects.equals(financialTypeId, category.financialTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, color, description, userId, financialTypeId);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", financialTypeId=" + financialTypeId +
                '}';
    }
}