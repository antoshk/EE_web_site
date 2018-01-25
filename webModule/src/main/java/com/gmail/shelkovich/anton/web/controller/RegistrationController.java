package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.model.dto.entity.UserDTO;
import com.gmail.shelkovich.anton.web.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(value = "/reg")
public class RegistrationController {

    @Autowired
    UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
       binder.addValidators(userValidator);
    }

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String regForm(ModelMap model) throws IOException {
        model.addAttribute("newUser", new UserDTO());
        return "register";
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String regRequest(@Valid @ModelAttribute("newUser") UserDTO user, BindingResult result, ModelMap model) throws IOException {
        if(result.hasErrors()){
            return "register";
        }
        return "profile";
    }

}
