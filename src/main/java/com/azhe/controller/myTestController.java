package com.azhe.controller;

import com.azhe.mapper.TPayPlatformMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Slf4j
@RestController
public class myTestController {

    @Autowired
    TPayPlatformMapper platformMapper;


    /**
     *http://localhost:666/tt
     */
    @PostMapping("/tt")
    public String tt(HttpServletRequest request, @RequestBody(required = false) String body) {
        try {
            StringBuilder headerBuilder = new StringBuilder("\n===== 所有請求 Header =====\n");

            // 列印所有 header
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                headerBuilder.append(headerName).append(": ").append(headerValue).append("\n");
            }

            log.info(headerBuilder.toString());

            // 印出 URI 與 body
            log.info("\n===== 請求資訊 =====\n" +
                    "URI: " + request.getRequestURI() + "\n" +
                    "Body:\n" + (body != null ? body : "No Body") +
                    "\n====================");

            return "tttest";

        } catch (Exception e) {
            log.error("發生錯誤", e);
            return "Error occurred!";
        }
    }




    @RequestMapping("/testMyBatisPlus")
    public String testMyBatisPlus( @RequestBody String s ) {
        // 打印请求体
        if (s != null) {
            System.out.println("Request Body(請求體):\n " + s);
        } else {
            System.out.println("Request Body: No body");
        }
        log.info("testPlus...");

        String myInput = s.split("=")[1];
        System.out.println(myInput);

        System.out.println(platformMapper.selectById(myInput));

        return "testMyBatisPlus";
    }


}
