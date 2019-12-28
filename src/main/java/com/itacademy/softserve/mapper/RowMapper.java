package com.itacademy.softserve.mapper;

import java.sql.ResultSet;

public interface RowMapper<TEntity> {
    TEntity maoToEntity(ResultSet resultSet);
}
