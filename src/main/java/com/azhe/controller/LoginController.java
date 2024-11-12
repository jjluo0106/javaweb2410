package com.azhe.controller;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.azhe.service.BrandService;
import com.azhe.service.LoginService;
import com.azhe.util.CaptchaGenerator;
import com.fasterxml.jackson.databind.util.JSONPObject;
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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
    public String testJSON(@RequestBody String a, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {

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
        String encode = URLEncoder.encode("張三", String.valueOf(StandardCharsets.UTF_8));
        Cookie cookie = new Cookie("name", encode);
        // 設置 Cookie 的屬性，例如有效期、路徑等
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60); // 1 天（以秒為單位）
        // 將 Cookie 添加到響應中
        response.addCookie(cookie);

        return "Cookie 已設置";
    }



    /*
    處理驗證碼
     */
    @GetMapping("/captcha")
    public String getCaptcha(HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("image/jpeg");


        try {
            /*
            request.getSession() 是 Java Web 應用程式中用來取得 HttpSession 物件的方法。
            這個方法可以做以下兩件事情：
            創建新的 Session：如果當前用戶沒有現有的 Session（例如首次訪問網站），則 request.getSession() 會自動創建一個新的 HttpSession 物件，
            並為該用戶分配唯一的 JSESSIONID。
            取得現有的 Session：如果該用戶已經有一個有效的 Session，則 request.getSession() 會返回現有的 HttpSession 物件。
             */
            // 在提交回應前創建 session
            HttpSession session = request.getSession();
            String captchaCode = CaptchaGenerator.generateRandomCode(1);
            session.setAttribute("captchaCode", captchaCode);

            // 然後再生成圖像並寫入回應
            CaptchaGenerator.generateCaptcha(200, 50, response.getOutputStream(), captchaCode);

            logger.info("驗證碼獲取測試，存入服務器captchaCode : {}", captchaCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }


    /*
    處理登入判斷
     */
    @PostMapping("/dealLogin")
    public ResponseEntity<String> dealLogin(@RequestParam String username,
                                          @RequestParam String password,
                                          @RequestParam String captcha,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws IOException {


        JSONObject responseObj = new JSONObject();
        // 先檢查驗證碼是否正確
        String sessionCaptcha = (String) request.getSession().getAttribute("captchaCode");
        if (sessionCaptcha == null) {
            logger.info("用戶正確驗證碼: {}, 欄位: {}", sessionCaptcha, captcha);
            responseObj.put("message", "請刷新驗證碼");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObj.toString());
        }else if(!sessionCaptcha.equals(captcha)){
            logger.info("用戶正確驗證碼: {}, 欄位: {}", sessionCaptcha, captcha);
            responseObj.put("message", "驗證碼輸入錯誤");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObj.toString());
        }



        ResponseEntity<String> stringResponseEntity = loginService.dealLogin(username, password, captcha, request);


        JSONObject jsonObject = JSONUtil.parseObj(stringResponseEntity.getBody());


        if("true".equals(jsonObject.get("success"))){
            logger.info("成功");
//            跳转/home

            responseObj.put("message", "Login success");
            responseObj.put("url", "/home");
            return ResponseEntity.status(HttpStatus.OK).body(responseObj.toString());


//            return ResponseEntity.status(HttpStatus.OK).body("Login success: " + jsonObject.get("\"ur\":\""+ "/home" +"\""));
//            response.sendRedirect("/home");
//            return null;
        }
        logger.info("失敗");

        // 返回失敗訊息
        responseObj.put("message", "密碼錯誤");

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseObj.toString());
    }

    private boolean captchaIsValid(String captcha) {
        if (code.equals(captcha)) return true;
        return false;
    }


    @PostMapping("/dealLogOut")
    public void logout(HttpServletRequest request){
        // 刪除session!!
        Object userID = request.getSession().getAttribute("userID");

        logger.info("登出");
        logger.info("userID : {}",userID);
        request.getSession().invalidate(); // 銷毀session
    }
}
