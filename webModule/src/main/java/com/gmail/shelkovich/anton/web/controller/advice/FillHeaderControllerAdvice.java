package com.gmail.shelkovich.anton.web.controller.advice;

import com.gmail.shelkovich.anton.service.BucketService;
import com.gmail.shelkovich.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class FillHeaderControllerAdvice {

    @Autowired
    BucketService bucketService;

    @Autowired
    UserService userService;

    @ModelAttribute
    public void addBugetToModel(Model model) {
        model.addAttribute("numProductsInBucket", bucketService.getTotalCount());
        model.addAttribute("userIdentifier", userService.getCurrentUsername());
    }

}
