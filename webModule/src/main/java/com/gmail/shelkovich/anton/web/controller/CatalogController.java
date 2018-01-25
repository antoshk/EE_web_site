package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    private final int productPerPage = 9;

    @Autowired
    ProductService productService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String productsFirstPage(ModelMap model) throws IOException {
        model.addAttribute("catalog", productService.getProductsByPage(productPerPage, 1));
        model.addAttribute("pagination", productService.getPagination(productPerPage, 1));
        return "catalog";
    }

    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public String productsPage(@PathVariable int page, ModelMap model) throws IOException {
        model.addAttribute("catalog", productService.getProductsByPage(productPerPage, page));
        model.addAttribute("pagination", productService.getPagination(productPerPage, page));
        return "catalog";
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String productsPage(@PathVariable Long productId, ModelMap model) throws IOException {
        model.addAttribute("product", productService.getProductById(productId));
        model.addAttribute("pageCount", productService.getPageCount(productPerPage));
        return "product";
    }


}
