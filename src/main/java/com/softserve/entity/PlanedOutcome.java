package com.softserve.entity;

import java.util.Date;

public class PlanedOutcome {

    public static enum PlanedOutcomeEntityQueries {

        INSERT(SqlQueries.INSERT, "INSERT INTO planned_outcomes (sum, date, note, user_id, category_id) VALUES (?, ?, ?, ?, ?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT sum, date, note, user_id, category_id FROM records WHERE id = ?"),
        GET_ALL_BY_USER_ID(SqlQueries.GET_ALL_BY_USER_ID, "SELECT * FROM planned_outcomes WHERE user_id = ?"),
        GET_ALL_BY_USER_ID_AND_DATE_RANGE(SqlQueries.GET_ALL_BY_USER_ID_AND_DATE_RANGE, "SELECT * FROM planned_outcomes WHERE user_id = ? AND date BETWEEN ? AND ?"),
        UPDATE(SqlQueries.UPDATE, "UPDATE planned_outcomes SET sum = ?, date = ?, note = ?, user_id = ?, category_id = ? WHERE id = ?"),
        DELETE(SqlQueries.DELETE, "DELETE FROM planned_outcomes WHERE id = ?");

        private SqlQueries sqlQuery;
        private String query;

        PlanedOutcomeEntityQueries(SqlQueries sqlQuery, String query) {
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
    private Double sum;
    private Date date;
    private String note;
    private Long userId;
    private Long categoryId;

}