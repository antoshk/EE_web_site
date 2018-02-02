package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.FeedbackService;
import com.gmail.shelkovich.anton.service.model.dto.FeedbackDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public String errorPage(ModelMap model) throws IOException {
        model.addAttribute("feedback", new FeedbackDTO());
        return "error";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateProduct(@Valid @ModelAttribute("product") FeedbackDTO feedback, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        feedbackService.save(feedback);
        return "redirect:/";
    }
}
