package com.chenson2910.mycrudboot.controllers;

import com.chenson2910.mycrudboot.model.User;
import com.chenson2910.mycrudboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final UserDetailServiceImpl userDetailsService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService, UserDetailServiceImpl userDetailsService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userDetailsService = userDetailsService;
    }


    @GetMapping({"","list"})
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.listAll());
        model.addAttribute("allRoles", roleService.findAllRoles());
        model.addAttribute("showUserProfile",
                model.containsAttribute("user") && !((User) model.getAttribute("user")).isNew());
        model.addAttribute("showNewUserForm",
                model.containsAttribute("user") && ((User) model.getAttribute("user")).isNew());
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "admin-page";
    }

    @GetMapping("/{id}/profile")
    public String showUserProfileModal(@PathVariable("id") Integer userId, Model model) throws UserNotFoundException {

            model.addAttribute("allRoles", roleService.findAllRoles());
            model.addAttribute("user", userService.get(userId));
            return "fragments/user-form";
    }


    @PostMapping()
    public String insertUser(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/admin";
    }

    @DeleteMapping("")
    public String deleteUser(@ModelAttribute("user") User user) throws UserNotFoundException {
        userService.delete(user.getId());
        return "redirect:/admin";
    }

    @PatchMapping()
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/admin";
    }
}
