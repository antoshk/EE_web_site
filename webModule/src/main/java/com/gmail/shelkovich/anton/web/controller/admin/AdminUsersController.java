package com.gmail.shelkovich.anton.web.controller.admin;

import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/admin/users")
public class AdminUsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String getUsers(ModelMap model) throws IOException {
        return "editUsers";
    }

    @RequestMapping(value = {"/ajax"}, method = RequestMethod.GET)
    public String getAjaxUsers(ModelMap model) throws IOException {
        model.addAttribute("users", userService.getAll());
        return "ajax_admin_userList";
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getSingleUser(@PathVariable Long userId, ModelMap model) throws IOException {
        UserDTO user = userService.getById(userId);
        user.setPassword("");
        model.addAttribute("user", user);
        return "editSingleUser";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public String updateUser(@PathVariable Long userId, @ModelAttribute("user") UserDTO user) throws IOException {

        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long userId, ModelMap model) throws IOException {
        userService.deleteUser(userId);
        model.addAttribute("users", userService.getAll());
        return "ajax_admin_userList";
    }

    @RequestMapping(value = "/{userId}/block", method = RequestMethod.POST)
    public String blockUser(@PathVariable Long userId, ModelMap model) throws IOException {
        userService.blockUser(userId);
        model.addAttribute("users", userService.getAll());
        return "ajax_admin_userList";
    }

    @RequestMapping(value = "/{userId}/unblock", method = RequestMethod.POST)
    public String unblockUser(@PathVariable Long userId, ModelMap model) throws IOException {
        userService.unblockUser(userId);
        model.addAttribute("users", userService.getAll());
        return "ajax_admin_userList";
    }

}
