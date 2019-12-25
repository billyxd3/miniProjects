package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.Task;

import java.util.List;
import java.util.Optional;

public class TaskDao implements Crud<Task> {
    @Override
    public boolean create(Task createdObject) {
        return false;
    }

    @Override
    public Optional<Task> findByID(long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public boolean update(Task objectToUpdate) {
        return false;
    }

    @Override
    public boolean deleteByID(long id) {
        return false;
    }
}
