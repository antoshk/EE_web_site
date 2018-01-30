package com.gmail.shelkovich.anton.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String adminMainPage(ModelMap model) throws IOException {
        return "profile";
    }



    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String productsFirstPage(ModelMap model) throws IOException {
        return "profile";
    }
}
