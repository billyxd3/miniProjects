package com.itacademy.softserve.dao;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {
    boolean create(T createdObject);
    Optional<T> findByID(long id);
    List<T> getAll();
    boolean update(T objectToUpdate);
    boolean deleteByID(long id);
}
