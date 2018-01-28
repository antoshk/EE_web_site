package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.repository.dao.Role;
import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import com.gmail.shelkovich.anton.web.controller.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(value = "/reg")
public class RegistrationController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
       binder.addValidators(userValidator);
    }

    @RequestMapping( method = RequestMethod.GET)
    public String regForm(ModelMap model, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        model.addAttribute("newUser", new UserDTO());
        return "register";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String regRequest(@Valid @ModelAttribute("newUser") UserDTO user, BindingResult result, ModelMap model, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        System.out.println(user.getFullName());
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(result.hasErrors()){
            return "register";
        }
        user.setRole(Role.USER);
        user.setActive(true);
        userService.addNewUser(user);
        return "profile";
    }

}
