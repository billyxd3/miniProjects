package com.itacademy.softserve.dao;

public interface IDaoRead<TEntity> {
    TEntity getByID();
    TEntity getByField();
}
