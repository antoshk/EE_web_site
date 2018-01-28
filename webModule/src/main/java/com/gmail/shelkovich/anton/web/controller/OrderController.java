package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.BucketService;
import com.gmail.shelkovich.anton.service.OrderService;
import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private BucketService bucketService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String ordersPage(ModelMap model) throws IOException {
        return "orders";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmOrder(ModelMap model) throws IOException {
        if(bucketService.getTotalCount()<1) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("bucket", bucketService.getAll());
        model.addAttribute("totalPrice", bucketService.getTotalPrice());
        return "confirmOrder";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addOrder(ModelMap model) throws IOException {
        if(bucketService.getTotalCount()<1) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        OrderDTO order = orderService.generateOrder(userService.getCurrentUser());
        Long newId = orderService.addNewOrder(order);
        bucketService.cleanBucket();
        return "redirect:/order/"+newId;
    }

    @GetMapping(value = "/{orderId}")
    public String productsPage(@PathVariable Long orderId, ModelMap model) throws IOException {
        OrderDTO order = orderService.getById(orderId);
        model.addAttribute("order", order);
        model.addAttribute("totalPrice", orderService.getTotalPrice(order));
        return "singleOrder";
    }

}
