package com.azhe.controller;


import com.azhe.pojo.Brand;
import com.azhe.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    BrandService brandService;


    @RequestMapping("/test")
    public List<Brand>  test(){


        return brandService.testBrand();
    }
}
