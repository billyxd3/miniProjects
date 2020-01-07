package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getPageSet(UserDto userDto, int begin);
    boolean save(TaskDto taskDto);
    void changeStatus(List<TaskDto> tasks);
    int getNumberOfPages();
    boolean setDone(Long taskId);
    boolean setDelete(Long taskId);
}

