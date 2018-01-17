package com.gmail.shelkovich.anton.web.serlvet.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductsApiServlet extends HttpServlet {

    private static final long serialVersionUID = 4946895713698474595L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(AdminJspPages.EDIT_PRODUCT_LIST).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(AdminJspPages.EDIT_PRODUCT_LIST).forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(AdminJspPages.EDIT_PRODUCT_LIST).forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(AdminJspPages.EDIT_PRODUCT_LIST).forward(req, resp);
    }
}
