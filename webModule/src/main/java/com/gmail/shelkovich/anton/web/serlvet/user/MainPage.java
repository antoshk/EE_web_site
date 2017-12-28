package com.gmail.shelkovich.anton.web.serlvet.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPage extends HttpServlet {

    private static final long serialVersionUID = 189461158283277791L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(UserJspPages.MAIN_PAGE).forward(req, resp);
    }
}
