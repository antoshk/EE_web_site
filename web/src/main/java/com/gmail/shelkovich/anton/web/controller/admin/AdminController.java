package com.gmail.shelkovich.anton.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String getUsers(ModelMap model) throws IOException {
        return "redirect:/admin/orders";
    }
}
