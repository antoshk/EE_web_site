package com.gmail.shelkovich.anton.web.controller.advice;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger logger = Logger.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public String processException(Exception e) {
        logger.error(e.getMessage(), e);
        return "redirect:/error";
    }

}
