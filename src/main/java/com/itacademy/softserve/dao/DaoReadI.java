package com.itacademy.softserve.dao;

import com.itacademy.softserve.builder.InstanceBuilder;

import java.util.List;

public interface DaoReadI<TEntity> {
    TEntity getByID(InstanceBuilder<TEntity> builder, Long id);
    List<TEntity> getByFields(InstanceBuilder<TEntity> builder, Object... fields);
    List<TEntity> getAll(InstanceBuilder<TEntity> builder, Long id);
}
