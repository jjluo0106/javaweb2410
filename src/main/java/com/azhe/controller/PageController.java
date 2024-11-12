package com.azhe.controller;

import com.azhe.pojo.PayAppType;
import com.azhe.pojo.User;
import com.azhe.service.LoginService;
import com.azhe.service.PayAppTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 網頁處理控制器
 */
@Slf4j
@Controller
public class PageController {

    @Autowired
    private LoginService loginService;
    @Autowired
    PayAppTypeService payAppTypeService;

    private void addUserListToModel(Model model) {
        List<User> users = loginService.selectAll();
        model.addAttribute("users", users);
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "World");
        return "greeting";
    }

//    @RequestMapping({"/login", "/home", "/paytools"})
//    public String page( String path) {
//
//        log.info("返回前端頁面 : {}", path);
//        return path;
//    }


//    @RequestMapping("/{path}")
//    public String page(@PathVariable String path) {
//        log.info("返回前端頁面 : {}", path);
//        return path;
//    }


    @RequestMapping("/payTool")
    public String payTool() {
        log.info("返回前端頁面 : payTool");

        return "payTool";
    }

}
