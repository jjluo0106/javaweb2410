package com.azhe.controller;


import com.azhe.pojo.Brand;
import com.azhe.service.BrandService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void testJSON(@RequestBody String json, HttpServletRequest request){


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
}
