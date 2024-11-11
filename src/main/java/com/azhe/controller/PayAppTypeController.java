package com.azhe.controller;

import com.azhe.pojo.PayAppType;
import com.azhe.service.PayAppTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PayAppTypeController {
    @Autowired
    PayAppTypeService payAppTypeService;

    @RequestMapping("/findTest4AppByAppCode")
    public List<PayAppType> findTest4AppByAppCode(PayAppType payAppType){
        log.info("findTest4AppByAppCode-查詢 {}資訊...", payAppType.getApp_code());
        return payAppTypeService.findTest4AppByAppCode(payAppType);
    }


    @PostMapping("/getMaxInfo")
    public String getMaxInfo(@RequestBody Object data){
        log.info("getMaxInfo-data : {}", data);
        String response = payAppTypeService.getMaxInfo(data);
        return response;
    }
}
