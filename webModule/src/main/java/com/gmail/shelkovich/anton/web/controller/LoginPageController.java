package com.gmail.shelkovich.anton.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginPageController {

    @RequestMapping(value="/login")
    public String loginPage(@RequestParam(value="from", required=false) String from, ModelMap model, HttpSession session) throws IOException {
        session.setAttribute("referURI", from);
        return "login";
    }

}
