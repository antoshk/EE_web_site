package com.gmail.shelkovich.anton.web.serlvet.admin;

import com.gmail.shelkovich.anton.web.serlvet.user.UserJspPages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPage extends HttpServlet {

    private static final long serialVersionUID = -5671835158368151153L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(AdminJspPages.MAIN_PAGE).forward(req, resp);
    }
}
