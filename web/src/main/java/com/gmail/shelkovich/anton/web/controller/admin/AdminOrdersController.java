package com.gmail.shelkovich.anton.web.controller.admin;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.OrderStatus;
import com.gmail.shelkovich.anton.service.OrderService;
import com.gmail.shelkovich.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrdersController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String ordersPage(ModelMap model) throws IOException {
        model.addAttribute("orders", orderService.getAll(SortOrder.DESC));
        return "editOrders";
    }

    @RequestMapping(value = "/{orderId}/edit", method = RequestMethod.POST)
    public String updateDoc(@PathVariable Long orderId, @RequestParam(value="status") String status){
        orderService.updateOrderStatus(orderId, OrderStatus.valueOf(status));
        return "redirect:/admin/orders";
    }

}
