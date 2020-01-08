package com.itacademy.softserve.util;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.NumberOfRecordsPerPage;
import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.HistoryService;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.service.impl.HistoryServiceImpl;
import com.itacademy.softserve.service.impl.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Pagination {
    private TaskService taskService = new TaskServiceImpl();

    private Integer getPage(HttpServletRequest request) {
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        return page;
    }

    public void homePagination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = getPage(request);
        if (SessionManager.isActiveSession(request)) {
            UserDto userDto = (UserDto) request.getSession(false).getAttribute("userDto");
            List<TaskDto> tasks = taskService.getPageSet(userDto, (page - 1) * NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE);
            request.setAttribute("taskList", tasks);
            request.setAttribute("numOfPages", taskService.getNumberOfPages());
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher(JspUrl.HOME_JSP).include(request, response);
        } else {
            request.getRequestDispatcher(JspUrl.MAIN_JSP).forward(request, response);
        }
    }

    public void searchPagination(HttpServletRequest request, HttpServletResponse response, String regex)
            throws ServletException, IOException {
        int page = getPage(request);
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if(SessionManager.isActiveSession(request)) {
            UserDto userDto = (UserDto) request.getSession(false).getAttribute("userDto");
            List<TaskDto> tasks = taskService.getSearchSet(userDto, regex, (page -1) * NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE);
            request.setAttribute("taskList", tasks);
            request.setAttribute("numOfPages", taskService.getNumberOfPages());
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher(JspUrl.SEARCH_JSP).include(request, response);
        } else {
            request.getRequestDispatcher(JspUrl.MAIN_JSP).forward(request, response);
        }
    }

    public void historyPagination(HttpServletRequest request, HttpServletResponse response, String period)
            throws ServletException, IOException {
        HistoryService historyService = new HistoryServiceImpl();
        int page = getPage(request);
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (SessionManager.isActiveSession(request)) {
            UserDto userDto = (UserDto) request.getSession(false).getAttribute("userDto");
            List<HistoryDto> historyList = historyService.getHistorySet(userDto, period, (page - 1) * NumberOfRecordsPerPage.HISTORY_RECORD_PER_PAGE);
            request.setAttribute("historyList", historyList);
            request.setAttribute("numOfPages", historyService.getNumberOfPages());
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher(JspUrl.HISTORY_JSP).include(request, response);
        } else {
            request.getRequestDispatcher(JspUrl.MAIN_JSP).forward(request, response);
        }
    }
}
