package com.example.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String authorization(Model model) {
        model.addAttribute("title", "Login Page");
        return "authPage";
    }
}
