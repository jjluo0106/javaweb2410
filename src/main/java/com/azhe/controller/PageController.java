package com.azhe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "World");
        return "greeting"; // 對應的是 greeting.ftl
    }


    @GetMapping("/login")
    public String login(Model model) {
//        model.addAttribute("name", "World");
        return "login"; // 對應的是 greeting.ftl
    }

    @GetMapping("/home")
    public String home(Model model) {
//        model.addAttribute("name", "World");
        return "home.ftl"; // 對應的是 greeting.ftl
    }
}
