package com.itacademy.softserve.dao;

import java.util.List;
import java.util.Optional;

public interface IDaoCrud<TEntity> extends IDaoRead<TEntity> {
    boolean insert(TEntity createdObject);
    boolean updateByEntity(TEntity objectToUpdate);
    boolean updateByID(long id);
    boolean updateByField();
    boolean deleteByEntity(TEntity objectToUpdate);
    boolean deleteByID(long id);
    boolean deleteByField(TEntity objectToUpdate);

}
