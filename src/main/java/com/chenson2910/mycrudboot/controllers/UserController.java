package com.chenson2910.mycrudboot.controllers;


import com.chenson2910.mycrudboot.service.UserDetailServiceImpl;
import com.chenson2910.mycrudboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserDetailServiceImpl userDetailService;

    @Autowired
    public UserController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping(value = "/")
    public String getUserPage(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("user", userDetailService.loadUserByUsername(principal.getName()));
        return "user";
    }
}