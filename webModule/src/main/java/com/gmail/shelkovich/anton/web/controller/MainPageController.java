package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    TempService tempService;

    @RequestMapping(value="/")
    public String mainPage(ModelMap model, HttpSession session) throws IOException {



        model.addAttribute("news", tempService.getNews().get(0));
        return "main";
    }




}
