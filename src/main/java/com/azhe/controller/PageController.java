package com.azhe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
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
        log.info("跳轉主業");
//        model.addAttribute("name", "World");
        return "home"; // 對應的是 greeting.ftl
    }
}
