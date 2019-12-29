package com.itacademy.softserve.dao;

import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.Entity;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.Arrays;

public abstract class ADaoCrud<TEntity extends Entity> extends ADaoRead<TEntity> implements IDaoCrud<TEntity> {
    protected ADaoCrud() {
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

    public boolean updateByID(long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), id);
        return status > 0;
    }

    @Override
    public boolean updateByField(Object fieldName, Object condition) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), fieldName, condition);
        return status > 0;
    }

    @Override
    public boolean deleteByEntity(TEntity objectToUpdate) {
        return deleteByID(objectToUpdate.getId());
    }

    @Override
    public boolean deleteByID(long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), id);
        return status > 0;
    }

    @Override
    public boolean deleteByField(Object fieldName, Object condition) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), fieldName, condition);
        return status > 0;
    }
}
