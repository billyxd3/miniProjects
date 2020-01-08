package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface HistoryService {
    List<HistoryDto> getHistorySet(UserDto userDto, String period, int begin);

    int getNumberOfPages();

    boolean clear(HttpServletRequest request);
}
