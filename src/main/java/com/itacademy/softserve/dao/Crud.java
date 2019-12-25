package com.itacademy.softserve.dao;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {
    long create(T createdObject);
    Optional<T> findByID(long id);
    List<T> getAll();
    long update(T objectToUpdate);
    long deleteByID(long id);
}
