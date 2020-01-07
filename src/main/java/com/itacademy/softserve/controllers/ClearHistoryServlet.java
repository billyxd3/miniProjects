package com.itacademy.softserve.controllers;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.constant.param.ControlTaskButton;
import com.itacademy.softserve.service.HistoryService;
import com.itacademy.softserve.service.impl.HistoryServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(ServletUrl.CLEAR_HISTORY)
public class ClearHistoryServlet extends HttpServlet {
    private HistoryService historyService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        historyService = new HistoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JspUrl.HISTORY_JSP).include(req, resp);
        resp.sendRedirect(req.getContextPath() + ServletUrl.HISTORY_URL);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        historyService.deleteRecord(Long.parseLong(request.getParameter(ControlTaskButton.DELETE)));
        doGet(request, response);
    }
}