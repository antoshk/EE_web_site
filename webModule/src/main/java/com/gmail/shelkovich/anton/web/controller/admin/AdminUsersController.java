package com.gmail.shelkovich.anton.web.controller.admin;

import com.gmail.shelkovich.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/admin/user")
public class AdminUsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(ModelMap model) throws IOException {
        model.addAttribute("users", userService.getAll());
        return "editUsers";
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String productsFirstPage(ModelMap model) throws IOException {
        return "profile";
    }

}
