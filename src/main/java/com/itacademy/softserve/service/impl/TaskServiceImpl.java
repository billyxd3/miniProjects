package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.constant.NumberOfRecordsPerPage;
import com.itacademy.softserve.constant.Statuses;
import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.TaskDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dao.builder.TaskBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dao.filter.TaskFilter;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.TaskDtoMapper;
import com.itacademy.softserve.entity.Status;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.service.TaskService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private List<Task> tasks;
    private TaskDao taskDao;
    private UserDao userDao;
    private UserBuilder userBuilder;

    public TaskServiceImpl() {
        taskDao = new TaskDao();
        userDao = new UserDao();
        userBuilder = new UserBuilder();
    }

    @Override
    public List<TaskDto> getPageSet(UserDto userDto, int begin) {
        Long userId = userDao.getByFields(userBuilder, userDto.getName()).get(0).getId();
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
        Long userId = userDao.getByFields(new UserBuilder(), userDto.getName()).get(0).getId();
        tasks = taskDao.getByRegex(new TaskBuilder(), userId,
                new StatusDao().getByFields(new StatusBuilder(), Statuses.DELETE).get(0).getId(), regex);
        return getSet(begin);
    }

    @Override
    public List<TaskDto> getFilteredByOwnerSet(String assignee, String owner, int begin) {
        Long assigneeId = userDao.getByFields(userBuilder, assignee).get(0).getId();
        Long ownerId = userDao.getByFields(userBuilder, owner).get(0).getId();
        tasks = new TaskFilter().filterByOwner(new TaskBuilder(), assigneeId, ownerId,
                new StatusDao().getByFields(new StatusBuilder(), Statuses.DELETE).get(0).getId().intValue());
        return getSet(begin);
    }

    @Override
    public List<TaskDto> getFilteredByDateSet(String userName, String beginDate, String endDate, int begin) {
        Long userId = userDao.getByFields(userBuilder, userName).get(0).getId();
        tasks = new TaskFilter().filterByDate(new TaskBuilder(), userId, Date.valueOf(beginDate),
                Date.valueOf(endDate), new StatusDao().getByFields(new StatusBuilder(), Statuses.DELETE).get(0).getId());
        return getSet(begin);
    }

    @Override
    public List<TaskDto> getFilteredByStatusSet(String userName, String status, int begin) {
        Long userId = userDao.getByFields(new UserBuilder(), userName).get(0).getId();
        Integer statusId = new StatusDao().getByFields(new StatusBuilder(), status).get(0).getId().intValue();
        tasks = new TaskFilter().filterByStatus(new TaskBuilder(), userId, statusId);
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
