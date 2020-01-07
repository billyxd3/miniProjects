package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.UserDto;

import java.util.List;

public interface HistoryService {
    List<HistoryDto> getHistorySet(UserDto userDto, int begin);
    boolean delete(Long userId);
    int getNumberOfPages();
    boolean deleteRecord(Long id);
}
