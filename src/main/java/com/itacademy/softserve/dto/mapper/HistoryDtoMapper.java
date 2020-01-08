package com.itacademy.softserve.dto.mapper;

import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.TaskDao;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dao.builder.TaskBuilder;
import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.entity.Entity;
import com.itacademy.softserve.entity.History;

public class HistoryDtoMapper implements DtoMapper<HistoryDto> {
    @Override
    public HistoryDto mapFromEntityToDto(Entity entity) {
        History history = (History) entity;
        HistoryDto historyDto = new HistoryDto();
        historyDto.setId(history.getId());
        historyDto.setTask(new TaskDao().getByID(new TaskBuilder(),history.getTaskID()).getDescription());
        historyDto.setModifiedDate(history.getModifiedDate());
        historyDto.setStatus(new StatusDao().getByID(new StatusBuilder(), Long.valueOf(history.getStatusID())).getName());
        return historyDto;
    }


}
