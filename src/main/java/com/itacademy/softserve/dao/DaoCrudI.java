package com.itacademy.softserve.dao;

public interface DaoCrudI<TEntity> extends DaoReadI<TEntity> {
    boolean insert(TEntity createdObject);
    boolean updateByEntity(TEntity objectToUpdate);
    boolean updateByID(Object... args);
    boolean updateByField(Object... fieldsValues);
    boolean deleteByEntity(TEntity objectToUpdate);
    boolean deleteByID(long id);
    boolean deleteByField(Object... fieldsValues);

}
