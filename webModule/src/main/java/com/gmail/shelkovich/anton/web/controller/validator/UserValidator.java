package com.gmail.shelkovich.anton.web.controller.validator;

import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors err) {
//        ValidationUtils.rejectIfEmpty(err, "fullName", "reg.user.fullName.empty");
        UserDTO user = (UserDTO) obj;

        if(user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())){
            err.rejectValue("confirmPassword", "reg.user.passwordsNotMatch");
        }

        if(userService.getByEmail(user.getEmail()) != null){
            err.rejectValue("email", "reg.user.email.alreadyExists");
        }
    }
}
