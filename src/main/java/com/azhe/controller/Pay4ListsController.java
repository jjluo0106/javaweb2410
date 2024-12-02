package com.azhe.controller;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.azhe.service.Pay4ListsService;
import com.azhe.service.PayMethodService;
import com.azhe.service.ThymeleafSqlGeneratorService;
import com.azhe.vo.PayPlatformAndModelVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class Pay4ListsController {
    @Autowired
    Pay4ListsService pay4ListsService;
    @Autowired
    ThymeleafSqlGeneratorService generator;
    @Autowired
    PayMethodService payMethodService;


    @PostMapping("/selPayPlatformAndModelVO")
    public List<PayPlatformAndModelVO> selModelByEng(@RequestBody PayPlatformAndModelVO payPlatformAndModelVO) {

        log.info("響應數量 : {}" , pay4ListsService.selModelByEng(payPlatformAndModelVO).size());
        return pay4ListsService.selModelByEng(payPlatformAndModelVO);
    }


//    @RequestMapping("/paySql")
//    public String generatePaySql(@RequestBody String param) {
//        System.out.println("第三方配置脚本导出");
//        System.out.println("param: " + param);
//        try {
//            // 将参数转为 JSONObject
//            JSONObject json = new JSONObject(param);
//
//            // 平台ID转集合
//            JSONArray channelsArray = json.getJSONArray("channels");
//            log.info("channelsArray : \n {}", channelsArray);
//            List<String> ids = channelsArray.toList(String.class);
//
//            // 导出的盘口
//            JSONArray platformsArray = json.getJSONArray("platforms");
//            log.info("platformsArray : \n {}", platformsArray);
//
//            List<PayPlatformAndModelVO> payPlatformAndModelVOS = new ArrayList<>();
//
//            for (Object obj : platformsArray) {
//                JSONObject platformJson = new JSONObject(obj);
//
//
//                // platformJson.toBean(對象.class) : 將
//                payPlatformAndModelVOS.add(platformJson.toBean(PayPlatformAndModelVO.class));
//            }
//
//            return generator.generateSqlFile(ids, payPlatformAndModelVOS);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "fail";
//        }
//    }


    @PostMapping("/testmap")
    public Object testmap(@RequestBody String rawRequestBody) {


        generator.generateSqlFile(rawRequestBody);

        return "接收成功";
    }




}
