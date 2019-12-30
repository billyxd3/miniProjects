package com.itacademy.softserve.dao;

import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.Entity;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.Arrays;

public abstract class DaoCrudA<TEntity extends Entity> extends DaoReadA<TEntity> implements DaoCrudI<TEntity> {
    protected DaoCrudA() {
        super();
    }

    protected abstract Object[] getFields(TEntity entity);

    public boolean insert(TEntity createdObject) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.INSERT).toString(),
                (Object[]) Arrays.copyOfRange(getFields(createdObject), 1, getFields(createdObject).length));
        return status == 1;
    }

    public boolean updateByEntity(TEntity objectToUpdate) {
        return updateByID(objectToUpdate.getId());
    }

    public boolean updateByID(Object... args) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), args);
        return status > 0;
    }

    @Override
    public boolean updateByField(Object... fieldsValues) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(), fieldsValues);
        return status > 0;
    }

    @Override
    public boolean deleteByEntity(TEntity objectToUpdate) {
        return deleteByID(objectToUpdate.getId());
    }

    @Override
    public boolean deleteByID(long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.DELETE_BY_ID).toString(), id);
        return status > 0;
    }

    @Override
    public boolean deleteByField(Object... fieldsValues) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.DELETE_BY_FIELD).toString(), fieldsValues);
        return status > 0;
    }
}
