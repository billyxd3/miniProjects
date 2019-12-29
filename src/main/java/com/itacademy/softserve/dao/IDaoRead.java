package com.itacademy.softserve.dao;

import java.util.List;

public interface IDaoRead<TEntity> {
    TEntity getByID(Long id);
    List<TEntity> getByFields(String... fields);
    List<TEntity> getAll();
}
