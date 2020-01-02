package com.itacademy.softserve.dao;

import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.*;

public abstract class DaoReadA<TEntity> implements DaoReadI<TEntity> {
    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    protected DaoReadA() {
        sqlQueries = new HashMap<>();
        init();
    }

    protected abstract void init();

    public TEntity getByID(InstanceBuilder<TEntity> builder, Long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntity(connection, sqlQueries.get(SqlQueries.GET_BY_ID).toString(), builder, id).get();
    }

    public List<TEntity> getByFields(InstanceBuilder<TEntity> builder, Object... fields) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), builder, fields);
    }

    public List<TEntity> getAll(InstanceBuilder<TEntity> builder, Long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, sqlQueries.get(SqlQueries.GET_ALL).toString(), builder, id);
    }
}
