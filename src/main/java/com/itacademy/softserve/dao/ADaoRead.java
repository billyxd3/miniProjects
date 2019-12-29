package com.itacademy.softserve.dao;

import com.itacademy.softserve.builder.InstanceBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.*;

public abstract class ADaoRead<TEntity> implements IDaoRead<TEntity> {
    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    protected ADaoRead() {
        sqlQueries = new HashMap<>();
    }

    protected abstract void init();

    public TEntity getByID(Long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntity(connection, sqlQueries.get(SqlQueries.GET_BY_ID).toString(), new InstanceBuilder<TEntity>(), id);
    }

    public List<TEntity> getByFields(String... fields) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), new InstanceBuilder<TEntity>(), (Object) fields);
    }

    public List<TEntity> getAll() {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getAll(connection, sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), new InstanceBuilder<TEntity>());
    }
}
