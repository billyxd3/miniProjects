package com.itacademy.softserve.dao;

import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.History;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.entity.Status;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;


public class HistoryDao extends ADaoCrud<History> {

    @Override
    protected void init() {
        for(History.HistoryEntityQueries historyEntityQueries : History.HistoryEntityQueries.values()) {
            sqlQueries.put(historyEntityQueries.getQuery(), historyEntityQueries);
        }
    }

    @Override
    protected Object[] getFields(History object) {
        Object[] fields = new Object[4];
        fields[0] = object.getId();
        fields[1] = object.getTaskID();
        fields[2] = object.getModifiedDate();
        fields[3] = object.getStatusID();
        return fields;
    }

}
