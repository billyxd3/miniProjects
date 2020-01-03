package com.itacademy.softserve.controllers;

import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.UserService;
import com.itacademy.softserve.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDto userDto = new UserDto(request.getParameter("name"), request.getParameter("password"));
        try {
            userService.login(userDto);
            response.sendRedirect(request.getContextPath() + "");//redirect to home page
        } catch (RuntimeException e) {
            request.setAttribute("error", "Bad credentials");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher("login.jsp")
                    .forward(request, response);
        }
    }
}