package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import com.gmail.shelkovich.anton.web.controller.validator.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private final Logger logger = Logger.getLogger(ProfileController.class);
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String profile(ModelMap model) throws IOException {
        model.addAttribute("user", userService.getCurrentUser());
        return "profile";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    public String editProfile(ModelMap model) throws IOException {
        model.addAttribute("user", userService.getCurrentUser());
        return "editProfile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveNewProfile(@Valid @ModelAttribute("user") UserDTO user, BindingResult result){
        if(result.hasErrors()){
            for(FieldError error: result.getFieldErrors()){
                String fieldName = error.getField();
                if(!fieldName.equals("email") && !fieldName.equals("password") && !fieldName.equals("confirmPassword")){
                    return "editProfile";
                }
            }
        }
        user.setId(userService.getCurrentUser().getId());
        userService.updateUserProfile(user);
        return "redirect:/profile";
    }

    @RequestMapping(value = {"/changePassword"}, method = RequestMethod.GET)
    public String changePasswordForm(ModelMap model) throws IOException {
        model.addAttribute("user", new UserDTO());
        return "changePassword";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String saveNewPassword(@Valid @ModelAttribute("user") UserDTO user, BindingResult result){
        if(result.hasErrors()){
            for(FieldError error: result.getFieldErrors()){
                String fieldName = error.getField();
                if(fieldName.equals("password") || fieldName.equals("confirmPassword")){
                    return "changePassword";
                }
            }
        }
        user.setId(userService.getCurrentUser().getId());
        userService.updateUserPassword(user);
        return "redirect:/profile";
    }


}
