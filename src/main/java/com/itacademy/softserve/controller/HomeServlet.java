package com.itacademy.softserve.controller;

import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.UserService;
import com.itacademy.softserve.service.impl.UserServiceImpl;
import com.itacademy.softserve.util.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(ServletUrl.HOME_URL)
public class HomeServlet extends HttpServlet {
    private Pagination pagination;
    private UserService userService;
    private String description;

    @Override
    public void init() {
        pagination = new Pagination();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);
        pagination.homePagination(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}