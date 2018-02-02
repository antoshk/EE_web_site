package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    @Value("${controller.productPerPage:9}")
    private Integer productPerPage;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String productsFirstPage(ModelMap model) throws IOException {
        model.addAttribute("catalog", productService.getByPage(productPerPage, null));
        model.addAttribute("pagination", productService.getPagination(productPerPage, null));
        return "catalog";
    }

    @GetMapping(value = "/page/{page}")
    public String productsPage(@PathVariable Integer page, ModelMap model) throws IOException {
        model.addAttribute("catalog", productService.getByPage(productPerPage, page));
        model.addAttribute("pagination", productService.getPagination(productPerPage, page));
        return "catalog";
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String productsPage(@PathVariable Long productId, ModelMap model) throws IOException {
        model.addAttribute("product", productService.getById(productId));
        return "product";
    }


}
