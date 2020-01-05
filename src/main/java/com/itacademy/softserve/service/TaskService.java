package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getPageSet(UserDto userDto, int begin);
    boolean changeStatus(Long taskId);
    int getNumberOfPages();
}

