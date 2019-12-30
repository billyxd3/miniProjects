package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.Status;

public class StatusDao extends DaoCrudA<Status> {

    @Override
    protected void init() {
        for (Status.StatusEntityQueries statusEntityQueries : Status.StatusEntityQueries.values()) {
            sqlQueries.put(statusEntityQueries.getQuery(), statusEntityQueries);
        }
    }

    @Override
    protected Object[] getFields(Status entity) {
        Object[] fields = new Object[2];
        fields[0] = entity.getId();
        fields[1] = entity.getName();
        return fields;
    }

}
