package com.azhe.service;

import com.azhe.vo.PayPlatformAndModelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class ThymeleafSqlGeneratorService {

    private final TemplateEngine templateEngine;

    public ThymeleafSqlGeneratorService() {
        // 配置 Thymeleaf
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".txt"); // 腳本文件的後綴
        resolver.setTemplateMode("TEXT"); // 模板文件的模式
        resolver.setCharacterEncoding("UTF-8");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }

//    public void generateSqlFile(String filePath, Map<String, Object> variables) throws Exception {
//        // 加載 Thymeleaf 上下文
//        Context context = new Context();
//        context.setVariables(variables);
//
//        // 生成 SQL 文件內容 指定template腳本
//        String content = templateEngine.process("addChannel123", context);
//
//        // 寫入文件
//        File file = new File(filePath);
//        File parent = file.getParentFile();
//        if (!parent.exists()) {
//            parent.mkdirs();
//        }
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//            writer.write(content);
//        }
//
//        System.out.println("SQL 文件生成成功：" + filePath);
//    }

    public String generateSqlFile(List<String> ids, List<PayPlatformAndModelVO> payPlatformAndModelVOS) throws Exception {
        // 加載 Thymeleaf 上下文
        Context context = new Context();
        HashMap<String, Object> map = new HashMap<>();
        // 產出腳本時間
        map.put("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));


        log.info("處理接口傳遞過來的值:\nid= {}\npayPlatformAndModelVOS = {}", ids, payPlatformAndModelVOS);
//        // 將所需的參數map傳遞給腳本
//        context.setVariables(variables);
//
//        // 生成 SQL 文件內容 指定template腳本
//        String content = templateEngine.process("addChannel123", context);
//
//        // 寫入文件
//        File file = new File(filePath);
//        File parent = file.getParentFile();
//        if (!parent.exists()) {
//            parent.mkdirs();
//        }
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//            writer.write(content);
//        }
//
//        System.out.println("SQL 文件生成成功：" + filePath);
        return  "test123456";
    }

//    public static void main(String[] args) throws Exception {
//        // 模擬輸入數據
//        List<Map<String, String>> channels = new ArrayList<>();
//        Map<String, String> channel1 = new HashMap<>();
//        channel1.put("payTypeId", "2");
//        channel1.put("payChannelName", "佰富支付微信小程序");
//        channel1.put("payPlatformCode", "100BAIFUZMK");
//        channel1.put("payChannelCode", "2006");
//
//        Map<String, String> channel2 = new HashMap<>();
//        channel2.put("payTypeId", "2");
//        channel2.put("payChannelName", "佰富支付微信話費");
//        channel2.put("payPlatformCode", "100BAIFUZMK");
//        channel2.put("payChannelCode", "2011");
//
//        Map<String, String> channel3 = new HashMap<>();
//        channel3.put("payTypeId", "4");
//        channel3.put("payChannelName", "佰富支付支付寶話費");
//        channel3.put("payPlatformCode", "100BAIFUZMK");
//        channel3.put("payChannelCode", "9002");
//
//        channels.add(channel1);
//        channels.add(channel2);
//        channels.add(channel3);
//
//        Map<String, Object> variables = new HashMap<>();
//        variables.put("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        variables.put("companyCode", "318");
//        variables.put("channels", channels);
//
//        // 生成 SQL 文件
//        ThymeleafSqlGeneratorService generator = new ThymeleafSqlGeneratorService();
//
//        LocalDate now = LocalDate.now();
//        String year = String.valueOf(now.getYear()) +"年";
//        String month = String.valueOf(now.getMonthValue()) + "月";
//        String day = String.valueOf(now.getDayOfMonth()) + "號";
//        String fileName = "我的名字";
//
//
//        List<String> list = Arrays.asList("C:", "Users", "j0981", "OneDrive", "桌面", "我的腳本", year, month, day, fileName + ".sql");
//
//        String filePath = String.join("//",list);
//
//        generator.generateSqlFile(filePath, variables);
//    }
}

