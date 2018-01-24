package com.gmail.shelkovich.anton.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginPageController {

    @RequestMapping(value="/login")
    public String loginPage(ModelMap model, HttpSession session) throws IOException {
        //model.addAttribute("user", new UserDTO());
        return "login";
    }

}
