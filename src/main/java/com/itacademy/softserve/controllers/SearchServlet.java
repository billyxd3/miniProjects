package com.itacademy.softserve.controllers;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.NumberOfRecordsPerPage;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.service.impl.TaskServiceImpl;
import com.itacademy.softserve.util.Pagination;
import com.itacademy.softserve.util.SessionManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(ServletUrl.SEARCH_TASK)
public class SearchServlet extends HttpServlet {
    private String regex;
    private Pagination pagination;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        pagination = new Pagination();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        pagination.searchPagination(req, resp, regex);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        regex = request.getParameter("regex");
        if(regex != null) {
            pagination.searchPagination(request, response, regex);
        } else {
            request.getRequestDispatcher(JspUrl.HOME_JSP).forward(request, response);
        }
    }
}