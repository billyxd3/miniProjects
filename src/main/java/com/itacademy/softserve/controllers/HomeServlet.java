package com.itacademy.softserve.controllers;

import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.util.Pagination;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(ServletUrl.HOME_URL)
public class HomeServlet extends HttpServlet {
    private Pagination pagination;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        pagination = new Pagination();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        pagination.homePagination(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}