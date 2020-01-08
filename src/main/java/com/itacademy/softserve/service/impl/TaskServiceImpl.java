package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.constant.NumberOfRecordsPerPage;
import com.itacademy.softserve.constant.Statuses;
import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.TaskDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dao.builder.TaskBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.TaskDtoMapper;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.service.TaskService;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private List<Task> tasks;
    private TaskDao taskDao = new TaskDao();

    public TaskServiceImpl() {
        taskDao = new TaskDao();
    }

    @Override
    public List<TaskDto> getPageSet(UserDto userDto, int begin) {
        Long userId = new UserDao().getByFields(new UserBuilder(), userDto.getName()).get(0).getId();
        tasks = taskDao.getAll(new TaskBuilder(), userId, userId,
                new StatusDao().getByFields(new StatusBuilder(), Statuses.DELETE).get(0).getId());
        return getSet(begin);
    }

    @Override
    public void changeStatus(List<TaskDto> tasks) {
        for (TaskDto taskDto : tasks) {

        }
    }

    @Override
    public boolean save(TaskDto taskDto) {
        UserDao userDao = new UserDao();
        Task task = new Task();
        task.setAssigneeID(userDao.getByFields(new UserBuilder(), taskDto.getAssignee()).get(0).getId());
        task.setOwnerID(userDao.getByFields(new UserBuilder(), taskDto.getOwner()).get(0).getId());
        task.setDescription(taskDto.getDescription());
        task.setCreationDate(taskDto.getCreationDate());
        task.setDeadline(taskDto.getDeadline());
        task.setStatusID(new StatusDao().getByFields(new StatusBuilder(), taskDto.getStatus()).get(0).getId().intValue());
        if (taskDao.insert(task)) {
            new HistoryServiceImpl().addRecord(task);
        }
        return true;
    }

    @Override
    public int getNumberOfPages() {
        if (tasks == null) {
            return 0;
        }
        return (int) Math.ceil(tasks.size() * 1.0 / NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE);
    }

    @Override
    public boolean setDone(Long taskId) {
        return taskDao.updateByID(new StatusDao().getByFields(new StatusBuilder(), Statuses.DONE).get(0).getId(), taskId);
    }

    @Override
    public boolean setDelete(Long taskId) {
        return taskDao.updateByID(new StatusDao().getByFields(new StatusBuilder(), Statuses.DELETE).get(0).getId(), taskId);
    }

    @Override
    public List<TaskDto> getSearchSet(UserDto userDto, String regex, int begin) {
        Long userId = new UserDao().getByFields(new UserBuilder(), userDto.getName()).get(0).getId();
        tasks = taskDao.getByRegex(new TaskBuilder(), userId,
                new StatusDao().getByFields(new StatusBuilder(), Statuses.DELETE).get(0).getId(), regex);
        return getSet(begin);
    }

    private List<TaskDto> getSet(int begin) {
        int end = begin + NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE;
        List<TaskDto> taskGroup = new ArrayList<>();
        if (end > tasks.size()) {
            end = tasks.size();
        }
        for (Task task : tasks.subList(begin, end)) {
            taskGroup.add(new TaskDtoMapper().mapFromEntityToDto(task));
        }
        return taskGroup;
    }
}
