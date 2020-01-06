package com.itacademy.softserve.controllers;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.HistoryService;
import com.itacademy.softserve.service.impl.HistoryServiceImpl;
import com.itacademy.softserve.service.impl.TaskServiceImpl;
import com.itacademy.softserve.util.SessionManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(ServletUrl.HISTORY_URL)
public class HistoryServlet extends HttpServlet {
    private HistoryService historyService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        historyService = new HistoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int page = 1;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if(SessionManager.isActiveSession(req)) {
            UserDto userDto = (UserDto) req.getSession(false).getAttribute("userDto");
            List<HistoryDto> historyList = historyService.getHistorySet(userDto, (page -1) * HistoryServiceImpl.RECORDS_PER_PAGE);
            req.setAttribute("historyList", historyList);
            req.setAttribute("numOfPages", historyService.getNumberOfPages());
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher(JspUrl.HISTORY_JSP).include(req, resp);
        } else {
            req.getRequestDispatcher(JspUrl.MAIN_JSP).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}