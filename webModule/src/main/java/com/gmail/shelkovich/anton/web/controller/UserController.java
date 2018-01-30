package com.gmail.shelkovich.anton.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String productsFirstPage(ModelMap model) throws IOException {
        return "profile";
    }



}
