package com.example.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    @GetMapping("")
    public String authorization(Model model) {
        model.addAttribute("title", "Store Page");
        return "view/pages/storePage";
    }
}
