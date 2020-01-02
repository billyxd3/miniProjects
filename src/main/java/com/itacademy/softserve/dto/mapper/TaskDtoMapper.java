package com.itacademy.softserve.dto.mapper;

import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.entity.Entity;
import com.itacademy.softserve.entity.Task;

public class TaskDtoMapper implements DtoMapper<TaskDto> {
    @Override
    public TaskDto mapToDto(Entity entity) {
        Task task = (Task) entity;
        TaskDto taskDto = new TaskDto();
        UserDao userDao = new UserDao();
        taskDto.setAssignee(userDao.getByID(new UserBuilder(),task.getAssigneeID()).getName());
        taskDto.setOwner(userDao.getByID(new UserBuilder(), task.getOwnerID()).getName());
        taskDto.setDescription(task.getDescription());
        taskDto.setCreationDate(task.getCreationDate());
        taskDto.setDeadline(task.getDeadline());
        taskDto.setStatus(new StatusDao().getByID(new StatusBuilder(), Long.valueOf(task.getStatusID())).getName());
        return null;
    }
}
