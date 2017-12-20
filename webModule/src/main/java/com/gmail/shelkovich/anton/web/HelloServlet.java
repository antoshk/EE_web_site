package com.gmail.shelkovich.anton.web;

import com.gmail.shelkovich.anton.service.ServSayHello;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(HelloServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        logger.debug("some message");
        PrintWriter out = resp.getWriter();
        out.println("web hello \n"+new ServSayHello().sayHello());
    }
}
