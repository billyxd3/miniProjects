package com.itacademy.softserve.service;

import com.itacademy.softserve.dao.TaskDao;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TaskService {
    List<TaskDto> getPageSet(UserDto userDto, int begin);

    boolean save(TaskDto taskDto);

    void changeStatus(List<TaskDto> tasks);

    int getNumberOfPages();

    boolean setDone(Long taskId);

    boolean setDelete(Long taskId);

    List<TaskDto> getSearchSet(UserDto userDto, String regex, int begin);
}

