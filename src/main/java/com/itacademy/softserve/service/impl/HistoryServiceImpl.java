package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.dao.HistoryDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.HistoryBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.HistoryDtoMapper;
import com.itacademy.softserve.entity.History;
import com.itacademy.softserve.service.HistoryService;

import java.util.ArrayList;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private List<History> historyList;
    private HistoryDao historyDao;
    public static final int RECORDS_PER_PAGE = 10;

    public HistoryServiceImpl() {
        historyDao = new HistoryDao();
    }

    @Override
    public List<HistoryDto> getHistorySet(UserDto userDto, int begin) {
        int end = begin + RECORDS_PER_PAGE;
        Long userId = new UserDao().getByFields(new UserBuilder(), userDto.getName()).get(0).getId();
        if(historyList == null) {
            historyList = historyDao.getAll(new HistoryBuilder(), userId);
        }
        List<HistoryDto> historyGroup = new ArrayList<>();
        if(end > historyList.size()) {
            end = historyList.size();
        }
        for(History historyRecord : historyList.subList(begin, end)) {
            historyGroup.add(new HistoryDtoMapper().mapToDto(historyRecord));
        }
        return historyGroup;
    }

    public static void main(String[] args) {
        int count = 0;
        List<History> his = new HistoryDao().getAll(new HistoryBuilder(), 1);
     //   his.forEach(h -> System.out.println(new HistoryDtoMapper().mapToDto(h)));
        HistoryDto historyDto = new HistoryDtoMapper().mapToDto(his.get(50));
        System.out.println(historyDto);
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public int getNumberOfPages() {
        if(historyList == null) {
            return 0;
        }
        return (int)Math.ceil(historyList.size() * 1.0 / RECORDS_PER_PAGE);
    }
}
