package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.constant.HistoryPeriod;
import com.itacademy.softserve.constant.NumberOfRecordsPerPage;
import com.itacademy.softserve.constant.param.ControlTaskButton;
import com.itacademy.softserve.dao.HistoryDao;
import com.itacademy.softserve.dao.TaskDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.HistoryBuilder;
import com.itacademy.softserve.dao.builder.TaskBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dao.filter.HistoryFilter;
import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.HistoryDtoMapper;
import com.itacademy.softserve.entity.History;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.service.HistoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private List<History> historyList;
    private HistoryDao historyDao;
    private HistoryFilter historyFilter;

    public HistoryServiceImpl() {
        historyDao = new HistoryDao();
        historyFilter = new HistoryFilter();
    }

    @Override
    public List<HistoryDto> getHistorySet(UserDto userDto, String period, int begin) {
        Long userId = new UserDao().getByFields(new UserBuilder(), userDto.getName()).get(0).getId();
        if (period.equals(HistoryPeriod.TODAY)) {
            historyList = historyFilter.getToday(userId);
        } else if (period.equals(HistoryPeriod.LAST_WEEK)) {
            historyList = historyFilter.getLastWeek(userId);
        } else if (period.equals(HistoryPeriod.LAST_MONTH)) {
            historyList = historyFilter.getLastMonth(userId);
        } else if (period.equals(HistoryPeriod.LAST_YEAR)) {
            historyList = historyFilter.getLastYear(userId);
        } else {
            historyList = historyDao.getAll(new HistoryBuilder(), userId);
        }
        Collections.reverse(historyList);
        return getSet(begin);
    }

    @Override
    public int getNumberOfPages() {
        if (historyList == null) {
            return 0;
        }
        return (int) Math.ceil((double) historyList.size() / NumberOfRecordsPerPage.HISTORY_RECORD_PER_PAGE);
    }

    @Override
    public boolean clear(HttpServletRequest request) {
        String action = request.getParameter(ControlTaskButton.DELETE);
        if (action != null) {
            return historyDao.deleteByID(Long.parseLong(request.getParameter(ControlTaskButton.DELETE)));
        } else {
            UserDto userDto = (UserDto) request.getSession(false).getAttribute("userDto");
            return historyDao.deleteByField(new UserDao().getByFields(new UserBuilder(), userDto.getName()).get(0).getId());
        }
    }

    public boolean addRecord(Task task) {
        History historyRecord = new History();
        historyRecord.setTaskID(new TaskDao().getByFields(new TaskBuilder(), task.getAssigneeID(), task.getOwnerID(),
                task.getDescription(), task.getCreationDate(), task.getStatusID()).get(0).getId());
        historyRecord.setModifiedDate(task.getCreationDate());
        historyRecord.setStatusID(task.getStatusID());
        historyRecord.setUserID(task.getAssigneeID());
        return new HistoryDao().insert(historyRecord);
    }

    private List<HistoryDto> getSet(int begin) {
        List<HistoryDto> historyGroup = new ArrayList<>();
        int end = begin + NumberOfRecordsPerPage.HISTORY_RECORD_PER_PAGE;
        if (end > historyList.size()) {
            end = historyList.size();
        }
        for (History historyRecord : historyList.subList(begin, end)) {
            historyGroup.add(new HistoryDtoMapper().mapFromEntityToDto(historyRecord));
        }
        return historyGroup;
    }
}
