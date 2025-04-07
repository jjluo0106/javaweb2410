package com.azhe.controller;
//import com.azhe.service.Pay4ListsService;
import com.azhe.anno.GetRunTime;
import com.azhe.service.Pay4ListsService;
import com.azhe.service.PayMethodService;
import com.azhe.service.PaySqlGeneratorService;
import com.azhe.vo.PayPlatformAndModelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Pay4ListsController {
    @Autowired
    Pay4ListsService pay4ListsService;
    @Autowired
    PaySqlGeneratorService generator;
    @Autowired
    PayMethodService payMethodService;


    @PostMapping("/selPayPlatformAndModelVO")
    @GetRunTime
    public List<PayPlatformAndModelVO> selectModelByInputBoxes(@RequestBody PayPlatformAndModelVO payPlatformAndModelVO) {

        log.info("響應數量 : {}" , pay4ListsService.selectModelByInputBoxes(payPlatformAndModelVO).size());
        return pay4ListsService.selectModelByInputBoxes(payPlatformAndModelVO);
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

        return generator.generateSqlFile(rawRequestBody);
    }




}
