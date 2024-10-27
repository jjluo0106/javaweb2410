package com.azhe.controller;

import com.azhe.pojo.User;
import com.azhe.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class PageController {

    @Autowired
    LoginService loginService;

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
        List<User> users = loginService.selectAll();
        model.addAttribute("users", users);
        log.info("跳轉主業");
        return "home"; // 對應的是 greeting.ftl
    }


    @GetMapping("/layout")
    public String layout(Model model) {
//        List<User> users = loginService.selectAll();
//        model.addAttribute("users", users);
        log.info("pay工程工具");
        return "layout"; // 對應的是 greeting.ftl
    }
}
