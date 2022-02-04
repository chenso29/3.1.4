package com.chenson2910.mycrudboot.controllers;

import com.chenson2910.mycrudboot.model.Role;
import com.chenson2910.mycrudboot.model.User;
import com.chenson2910.mycrudboot.service.RoleService;
import com.chenson2910.mycrudboot.service.UserNotFoundException;
import com.chenson2910.mycrudboot.service.UserService;
import com.chenson2910.mycrudboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
@Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }




    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> userList = userService.listAll();
        model.addAttribute("listUsers", userList);
        return "/users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "/user_form";
    }

    @PostMapping("/users/")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam(required = false) String roleAdmin, RedirectAttributes redirectAttributes) {
            userService.save(user);
        redirectAttributes.addFlashAttribute("message", "User successfully created");
        return "redirect:/admin/users";
    }

    @PutMapping("/users/{id}")
    public String showEditForm(@PathVariable("id") Integer id,
                               Model model, RedirectAttributes redirectAttributes) {
        try {
            User user = userService.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID " + id + ")");
            return "/user_form";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/users";
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Integer id,
                             RedirectAttributes redirectAttributes) {
        try {
            userService.delete(id);
            redirectAttributes.addFlashAttribute("message", "User deleted");
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/users";
    }
}
