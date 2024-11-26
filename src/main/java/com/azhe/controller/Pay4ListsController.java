package com.azhe.controller;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.azhe.service.Pay4ListsService;
import com.azhe.service.ThymeleafSqlGeneratorService;
import com.azhe.vo.PayPlatformAndModelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class Pay4ListsController {
    @Autowired
    Pay4ListsService pay4ListsService;
    @Autowired
    ThymeleafSqlGeneratorService generator;


    @PostMapping("/selPayPlatformAndModelVO")
    public List<PayPlatformAndModelVO> selModelByEng(@RequestBody PayPlatformAndModelVO payPlatformAndModelVO) {

        log.info("響應數量 : {}" , pay4ListsService.selModelByEng(payPlatformAndModelVO).size());
        return pay4ListsService.selModelByEng(payPlatformAndModelVO);
    }


    @RequestMapping("/paySql")
    public String generatePaySql(@RequestBody String param) {
        System.out.println("第三方配置脚本导出");
        System.out.println("param: " + param);
        try {
            // 将参数转为 JSONObject
            JSONObject json = new JSONObject(param);

            // 平台ID转集合
            JSONArray channelsArray = json.getJSONArray("channels");
            List<String> ids = channelsArray.toList(String.class);

            // 导出的盘口
            JSONArray platformsArray = json.getJSONArray("platforms");
            List<PayPlatformAndModelVO> payPlatformAndModelVOS = new ArrayList<>();

            for (Object obj : platformsArray) {
                JSONObject platformJson = new JSONObject(obj);
                payPlatformAndModelVOS.add(platformJson.toBean(PayPlatformAndModelVO.class));
            }

            return generator.generateSqlFile(ids, payPlatformAndModelVOS);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
