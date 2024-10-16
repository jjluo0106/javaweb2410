package com.azhe.controller;


import com.azhe.service.BrandService;
import com.azhe.service.LoginService;
import com.azhe.util.CaptchaGenerator;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@RestController
public class LoginController {

    @Autowired
    BrandService brandService;

    @Autowired
    LoginService loginService;
    String code = "0000"; // 驗證碼


    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


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

    /*
    處理驗證碼
     */
    @GetMapping("/captcha")
    public String getCaptcha(HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("image/jpeg");

        System.out.println("驗證碼獲取測試");

        try {
            // 在提交回應前創建 session
            HttpSession session = request.getSession();
            String captchaCode = CaptchaGenerator.generateRandomCode(4);
            session.setAttribute("captchaCode", captchaCode);

            // 然後再生成圖像並寫入回應
            CaptchaGenerator.generateCaptcha(200, 50, response.getOutputStream(), captchaCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }


    @PostMapping("/dealLogin")
    public ResponseEntity<String> dealLogin(@RequestParam String username,
                                            @RequestParam String password,
                                            @RequestParam String captcha,
                                            HttpServletRequest request) {

        return loginService.dealLogin(username, password, captcha, request);
    }

    private boolean captchaIsValid(String captcha) {
        if (code.equals(captcha)) return true;
        return false;
    }
}
