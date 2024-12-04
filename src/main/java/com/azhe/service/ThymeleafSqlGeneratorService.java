package com.azhe.service;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.azhe.mapper.PlatformMapper;
import com.azhe.pojo.PayPlatform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class ThymeleafSqlGeneratorService {

    private final TemplateEngine templateEngine;

    @Autowired
    PlatformMapper platformMapper;

    public ThymeleafSqlGeneratorService() {
        // 配置 Thymeleaf
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html"); // 腳本文件的後綴 - 注意: 使用的腳本只能是html才能遍例！！
        resolver.setTemplateMode("TEXT"); // 模板文件的模式
        resolver.setCharacterEncoding("UTF-8");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }


    public String generateSqlFile(String rawRequestBody) {
        try {
            // 加載 Thymeleaf 上下文
            Context context = new Context();
            HashMap<String, Object> map = new HashMap<>();
            // 產出腳本時間
            map.put("currentDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));


            // 打印原始数据字符串
//            System.out.println("原始数据字符串：" + rawRequestBody);
            log.info("原始数据字符串:\n{}", rawRequestBody);
            log.info("解析字串:\n{}", JSONUtil.parseObj(rawRequestBody).toStringPretty());
            // 1. 將字符串轉為 JSONObject
            JSONObject jsonObject = JSONUtil.parseObj(rawRequestBody);
            System.out.println("JSONObject: " + jsonObject);
//
//        // 獲取字段值
//        String inputs = jsonObject.getStr("inputs");
//        String ZFs = jsonObject.getStr("ZFs");

            // 提取 inputs 并转为 List
            JSONArray inputsArray = jsonObject.getJSONArray("inputs");
            List<Map> inputsList = inputsArray.toList(Map.class);

            // 提取 ZFs 并转为 List
            JSONArray zfsArray = jsonObject.getJSONArray("ZFs");
            List<String> zfsList = zfsArray.toList(String.class);

            log.info("\ninputs:\n{}\nZFs:\n{}", inputsList, zfsList);


            List<PayPlatform> payPlatforms = platformMapper.queryTest4(zfsList.get(0));
            log.info("查询到的payPlatforms :\n{}", payPlatforms);
            payPlatforms.forEach(

                    platform -> {
                        log.info("payPlatformId: {}", platform.getPayPlatformId());

                        platform.setPayPlatformId(platform.getPayPlatformId() + 1);
                        platform.setMyPlatformCode("setMyPlatformCode");
                        platform.setMyPlatformName("setMyPlatformName");
                        platform.setMyMerchantCode("setMyMerchantCode");
                        platform.setMySecretCode("setMySecretCode");
                        platform.setRsaKey("setRsaKey");
                        platform.setMyPlatformName("setMyPlatformName");

                    }

            );
            map.put("payPlatforms", payPlatforms);
//            context.setVariable("payPlatforms", payPlatforms);
            // 將所需的參數map傳遞給腳本
            context.setVariables(map);

            log.info("1");
            // 生成 SQL 文件內容 指定template腳本
            String content = templateEngine.process("myScript", context);
            log.info("1");

            // 寫入文件
            File file = new File("C:\\Develop\\abc.sql");
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            log.info("1");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("SQL 文件生成成功：");
            return  "test123456";
        } catch (RuntimeException e) {
            log.info("錯誤 :\n{}",e);
            throw new RuntimeException(e);
        }
    }

}

