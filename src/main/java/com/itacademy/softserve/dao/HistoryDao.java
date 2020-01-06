package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.History;

import java.sql.Date;
import java.time.LocalDate;

public class HistoryDao extends DaoCrudA<History> {

    @Override
    protected void init() {
        for(History.HistoryEntityQueries historyEntityQueries : History.HistoryEntityQueries.values()) {
            sqlQueries.put(historyEntityQueries.getQuery(), historyEntityQueries);
        }
    }

    @Override
    protected Object[] getFields(History object) {
        Object[] fields = new Object[5];
        fields[0] = object.getId();
        fields[1] = object.getTaskID();
        fields[2] = object.getModifiedDate();
        fields[3] = object.getStatusID();
        fields[4] = object.getUserID();
        return fields;
    }
}
