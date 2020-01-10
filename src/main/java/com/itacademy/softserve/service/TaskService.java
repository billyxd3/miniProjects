package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TaskService {
    List<TaskDto> getPageSet(UserDto userDto, int begin);

    boolean save(TaskDto taskDto);

    void changeStatus(List<TaskDto> tasks);

    int getNumberOfPages();

    boolean setDone(Long taskId);

    boolean setDelete(Long taskId);

    boolean edit(HttpServletRequest request, String description);

    List<TaskDto> getSearchSet(UserDto userDto, String regex, int begin);

    List<TaskDto> getFilteredByOwnerSet(String assignee, String owner, int begin);

    List<TaskDto> getFilteredByDateSet(String userName, String beginDate, String endDate, int begin);

    List<TaskDto> getFilteredByStatusSet(String userName, String status, int begin);
}

