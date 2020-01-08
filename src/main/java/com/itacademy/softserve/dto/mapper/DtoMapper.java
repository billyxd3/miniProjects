package com.itacademy.softserve.dto.mapper;

import com.itacademy.softserve.entity.Entity;

public interface DtoMapper<TEntity> {
    TEntity mapFromEntityToDto(Entity entity);
}
