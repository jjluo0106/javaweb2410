package com.azhe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * 網頁處理控制器
 */
@Slf4j
@Controller
public class PageController {

//    @Autowired
//    private LoginService loginService;
//    @Autowired
//    PayAppTypeService payAppTypeService;
//
//    private void addUserListToModel(Model model) {
//        List<User> users = loginService.selectAll();
//        model.addAttribute("users", users);
//    }
//
//    @GetMapping("/greeting")
//    public String greeting(Model model) {
//        model.addAttribute("name", "World");
//        return "greeting";
//    }

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


    //  http://localhost:666/payTool
    @GetMapping("/payTool")
    public String payToolPage(Model model) {
        List<String> fieldNames = Arrays.asList(
                "payModelId", "payStrategyName", "platformCode",  "callbackReturnStrategy"
        );

        log.info("fieldNames : {}", fieldNames);
        model.addAttribute("fieldNames", fieldNames);
        return "payTool";
    }


}
