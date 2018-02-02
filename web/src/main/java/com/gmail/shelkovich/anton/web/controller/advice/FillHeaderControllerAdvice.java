package com.gmail.shelkovich.anton.web.controller.advice;

import com.gmail.shelkovich.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ControllerAdvice
public class FillHeaderControllerAdvice {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void addBugetToModel(Model model, HttpSession session, HttpServletRequest req) {
        session.setAttribute("userIdentifier", userService.getCurrentUsername());
        session.setAttribute("currentURI", req.getRequestURI());
    }

}
