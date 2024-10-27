package com.azhe.controller;


import cn.hutool.json.JSONObject;
import com.azhe.pojo.PayPlatform;
import com.azhe.service.PlatformService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    PlatformService platformService;

    @RequestMapping("/queryTest4")
    public List<PayPlatform> queryTest4() {
        log.info("查詢");
        return platformService.queryTest4();
    }
}
