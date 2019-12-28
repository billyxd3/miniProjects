package com.itacademy.softserve.dao;

import java.util.HashMap;
import java.util.Map;

public abstract class ADaoRead<TEntity> implements IDaoRead<TEntity> {
    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    protected ADaoRead() {
        sqlQueries = new HashMap<>();
    }
}
