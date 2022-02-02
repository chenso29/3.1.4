package com.chenson2910.mycrudboot.controllers;

import com.chenson2910.mycrudboot.model.Role;
import com.chenson2910.mycrudboot.model.User;
import com.chenson2910.mycrudboot.service.UserNotFoundException;
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

    private final UserServiceImpl userServiceImpl;


    @Autowired
    public AdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> userList = userServiceImpl.listAll();
        model.addAttribute("listUsers", userList);
        return "/users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "/user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam(required = false) String roleAdmin, RedirectAttributes redirectAttributes) {
        Set<Role> roles = new HashSet<>();
        roles.add(userServiceImpl.getRoleByName("ROLE_USER"));
        if (roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roles.add(userServiceImpl.getRoleByName("ROLE_ADMIN"));
        }
        user.setRoles(roles);
        userServiceImpl.save(user);
        redirectAttributes.addFlashAttribute("message", "User successfully created");
        return "redirect:/admin/users";
    }

    @PutMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,
                               Model model, RedirectAttributes redirectAttributes) {
        try {
            User user = userServiceImpl.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID " + id + ")");
            return "/user_form";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/users";
        }
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,
                             RedirectAttributes redirectAttributes) {
        try {
            userServiceImpl.delete(id);
            redirectAttributes.addFlashAttribute("message", "User deleted");
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/users";
    }
}
