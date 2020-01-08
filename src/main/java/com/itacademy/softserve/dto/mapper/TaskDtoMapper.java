package com.itacademy.softserve.dto.mapper;

import com.itacademy.softserve.constant.Statuses;
import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.Entity;
import com.itacademy.softserve.entity.Task;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;

public class TaskDtoMapper implements DtoMapper<TaskDto> {
    @Override
    public TaskDto mapFromEntityToDto(Entity entity) {
        Task task = (Task) entity;
        TaskDto taskDto = new TaskDto();
        UserDao userDao = new UserDao();
        taskDto.setTaskID(task.getId());
        taskDto.setAssignee(userDao.getByID(new UserBuilder(),task.getAssigneeID()).getName());
        taskDto.setOwner(userDao.getByID(new UserBuilder(), task.getOwnerID()).getName());
        taskDto.setDescription(task.getDescription());
        taskDto.setCreationDate(task.getCreationDate());
        taskDto.setDeadline(task.getDeadline());
        taskDto.setStatus(new StatusDao().getByID(new StatusBuilder(), Long.valueOf(task.getStatusID())).getName());
        return taskDto;
    }

    public TaskDto createDtoFromRequest(HttpServletRequest request) {
        UserDto userDto = (UserDto) request.getSession(false).getAttribute("userDto");
        TaskDto taskDto = new TaskDto();
        taskDto.setAssignee(request.getParameter("users"));
        taskDto.setOwner(userDto.getName());
        taskDto.setDescription(request.getParameter("description"));
        taskDto.setCreationDate(Date.valueOf(LocalDate.now()));
        taskDto.setDeadline(Date.valueOf(request.getParameter("deadline")));
        taskDto.setStatus(Statuses.CREATED);
        return taskDto;
    }
}
