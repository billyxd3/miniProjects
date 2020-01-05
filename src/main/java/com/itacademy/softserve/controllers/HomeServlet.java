package com.itacademy.softserve.controllers;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.service.TaskService;
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

@WebServlet(ServletUrl.HOME_URL)
public class HomeServlet extends HttpServlet {
    private TaskService taskService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        taskService = new TaskServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int page = 1;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if(new SessionManager().isActiveSession(req)) {
            UserDto userDto = (UserDto) req.getSession(false).getAttribute("userDto");
            List<TaskDto> tasks = taskService.getPageSet(userDto, (page -1) * TaskServiceImpl.RECORDS_PER_PAGE);
            req.setAttribute("taskList", tasks);
            req.setAttribute("numOfPages", taskService.getNumberOfPages());
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher(JspUrl.HOME_JSP).include(req, resp);
        } else {
            req.getRequestDispatcher(JspUrl.MAIN_JSP).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}