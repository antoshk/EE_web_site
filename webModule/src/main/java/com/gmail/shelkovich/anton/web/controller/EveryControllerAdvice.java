package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.BucketService;
import com.gmail.shelkovich.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class EveryControllerAdvice {

    @Autowired
    BucketService bucketService;

    @Autowired
    UserService userService;

    @ModelAttribute
    public void addBugetToModel(Model model) {
        model.addAttribute("numProductsInBucket", bucketService.getTotal());
        model.addAttribute("userIdentifier", userService.getUsernameFromSecurityContext());
    }

}
