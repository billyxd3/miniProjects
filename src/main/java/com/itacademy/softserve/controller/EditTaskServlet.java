package com.itacademy.softserve.controller;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.service.UserService;
import com.itacademy.softserve.service.impl.TaskServiceImpl;
import com.itacademy.softserve.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(ServletUrl.EDIT_TASK)
public class EditTaskServlet extends HttpServlet {
    private TaskService taskService;
    private UserService userService;
    private String description;

    @Override
    public void init() {
        taskService = new TaskServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        description = req.getParameter("description");
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);        req.getRequestDispatcher(JspUrl.EDIT_TASK).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("confirm");
        if (action != null) {
            taskService.edit(request, description);
        }
        response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);
    }
}