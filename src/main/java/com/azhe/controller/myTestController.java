package com.azhe.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class myTestController {

    @RequestMapping("/tt")
    public String tt(HttpServletRequest request, @RequestBody(required = false) String body) {
        try {
            // 获取请求头
            String contentType = request.getHeader("Content-Type");
            String userAgent = request.getHeader("User-Agent");

            // 打印请求头
            System.out.println("Content-Type(請求體格式):\n " + contentType);
            System.out.println("User-Agent(發送的設備):\n " + userAgent);


            System.out.println("getRequestURI ：　" + request.getRequestURI());

            // 打印请求体
            if (body != null) {
                System.out.println("Request Body(請求體):\n " + body);
            } else {
                System.out.println("Request Body: No body");
            }

            return "tttest";

        } catch (Exception e) {
            e.printStackTrace();  // 打印详细的异常堆栈信息
            return "Error occurred!";
        }
    }


}
