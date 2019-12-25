package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.History;

import java.util.List;
import java.util.Optional;

public class HistoryDao implements Crud<History> {
    @Override
    public boolean create(History createdObject) {
        return false;
    }

    @Override
    public Optional<History> findByID(long id) {
        return Optional.empty();
    }

    @Override
    public List<History> getAll() {
        return null;
    }

    @Override
    public boolean update(History objectToUpdate) {
        return false;
    }

    @Override
    public boolean deleteByID(long id) {
        return false;
    }
}
