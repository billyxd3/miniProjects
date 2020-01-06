package com.itacademy.softserve.controllers;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(ServletUrl.ADD_TASK_URL)
public class AddTaskServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JspUrl.ADD_TASK_JSP).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}