package com.azhe.controller;


import com.azhe.pojo.Brand;
import com.azhe.service.BrandService;
import com.azhe.util.CaptchaGenerator;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    BrandService brandService;


//    @RequestMapping("/test")
//    public List<Brand>  test(){
//
//
//        return brandService.testBrand();
//    }

    @RequestMapping("/testjson")
    public void testJSON(@RequestBody String json, HttpServletRequest request) {


        // 打印請求頭
        System.out.println("請求頭:");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
        }


        System.out.println("請求體:\n" + json);
        System.out.println("-------------------------------------------------------------");
    }


    @RequestMapping("/cookie")
    public String testJSON(@RequestBody String a, HttpServletResponse response, HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();


        Enumeration<String> headerNames = request.getHeaderNames();
        // 打印所有的請求頭
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                System.out.println(headerName + ": " + headerValue);
            }
        }


        if (cookies != null) {
            System.out.println("cookie 有: ");
            for (Cookie cookie : cookies) {
                System.out.println("Cookie 名稱: " + cookie.getName() + ", 值: " + cookie.getValue());
            }
        } else {
            System.out.println("未接收到任何 Cookie");
        }

        System.out.println("請求體: " + a);
        // 創建 Cookie
        String encode = URLEncoder.encode("張三", StandardCharsets.UTF_8);
        Cookie cookie = new Cookie("name", encode);
        // 設置 Cookie 的屬性，例如有效期、路徑等
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60); // 1 天（以秒為單位）
        // 將 Cookie 添加到響應中
        response.addCookie(cookie);

        return "Cookie 已設置";
    }


    @RequestMapping("/testSession")
    public String testSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("myAttribute", "123456~");

//        System.out.println(session.getId());

        System.out.println(session.getAttribute("myAttribute"));

        System.out.println("測試儲存Session...");


        session.invalidate();
        return "ok";
    }

    @RequestMapping("/testGetSession")
    public String testGetSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object myAttribute = session.getAttribute("myAttribute");
        System.out.println("myAttribute : " + myAttribute);
        return "ok";
    }


    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response) {
        response.setContentType("image/jpeg");

        System.out.println("給驗證碼圖案");
        try {
            CaptchaGenerator.generateCaptcha(200, 50, response.getOutputStream(), CaptchaGenerator.generateRandomCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
