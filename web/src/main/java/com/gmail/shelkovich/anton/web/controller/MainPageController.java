package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.NewsService;
import com.gmail.shelkovich.anton.service.ProductService;
import com.gmail.shelkovich.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MainPageController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private ProductService prductService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/")
    public String mainPage(ModelMap model, HttpSession session) throws IOException {
        model.addAttribute("news", newsService.getMainPageNews());
        model.addAttribute("products", prductService.getMainPageProducts());
        return "main";
    }




}
