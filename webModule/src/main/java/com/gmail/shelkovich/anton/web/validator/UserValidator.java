package com.gmail.shelkovich.anton.web.validator;

import com.gmail.shelkovich.anton.service.model.dto.entity.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors err) {
//        ValidationUtils.rejectIfEmpty(err, "fullName", "reg.user.fullName.empty");
//        ValidationUtils.rejectIfEmpty(err, "email", "reg.user.email.empty");
        ValidationUtils.rejectIfEmpty(err, "phone", "reg.user.emptyRequiredField");
//        ValidationUtils.rejectIfEmpty(err, "address", "reg.user.address.empty");



//        ValidationUtils.rejectIfEmpty(err, "password", "reg.user.password.empty");

        UserDTO user = (UserDTO) obj;

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(user.getEmail()).matches())) {
            err.rejectValue("email", "reg.user.email.invalid");
        }
    }
}
