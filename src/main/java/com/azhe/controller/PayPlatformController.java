package com.azhe.controller;


import com.azhe.pojo.TPayPlatform;
import com.azhe.service.PlatformService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/platform")
public class PayPlatformController {

    @Autowired
    PlatformService platformService;

    @RequestMapping("/queryTest4")
    public List<TPayPlatform> queryTest4(String ZF) {
        log.info("查詢");
        return platformService.queryTest4(ZF);
    }


//    @RequestMapping("/selectById")
//    public PayPlatform selectById(int id) {
//        log.info("測試查詢");
//        return platformService.selectById(id);
//    }
}
