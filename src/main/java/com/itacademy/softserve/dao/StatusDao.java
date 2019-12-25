package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.Status;

import java.util.List;
import java.util.Optional;

public class StatusDao implements Crud<Status> {
    @Override
    public boolean create(Status createdObject) {
        return false;
    }

    @Override
    public Optional<Status> findByID(long id) {
        return Optional.empty();
    }

    @Override
    public List<Status> getAll() {
        return null;
    }

    @Override
    public boolean update(Status objectToUpdate) {
        return false;
    }

    @Override
    public boolean deleteByID(long id) {
        return false;
    }
}
