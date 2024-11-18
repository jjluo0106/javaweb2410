package com.azhe.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ThymeleafSqlGenerator {

    private final TemplateEngine templateEngine;

    public ThymeleafSqlGenerator() {
        // 配置 Thymeleaf
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".txt");
        resolver.setTemplateMode("TEXT");
        resolver.setCharacterEncoding("UTF-8");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }

    public void generateSqlFile(String filePath, Map<String, Object> variables) throws Exception {
        // 加載 Thymeleaf 上下文
        Context context = new Context();
        context.setVariables(variables);

        // 生成 SQL 文件內容
        String content = templateEngine.process("addChannel", context);

        // 寫入文件
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }

        System.out.println("SQL 文件生成成功：" + filePath);
    }

    public static void main(String[] args) throws Exception {
        // 模擬輸入數據
        List<Map<String, String>> channels = new ArrayList<>();
        Map<String, String> channel1 = new HashMap<>();
        channel1.put("payTypeId", "2");
        channel1.put("payChannelName", "佰富支付微信小程序");
        channel1.put("payPlatformCode", "100BAIFUZMK");
        channel1.put("payChannelCode", "2006");

        Map<String, String> channel2 = new HashMap<>();
        channel2.put("payTypeId", "2");
        channel2.put("payChannelName", "佰富支付微信話費");
        channel2.put("payPlatformCode", "100BAIFUZMK");
        channel2.put("payChannelCode", "2011");

        Map<String, String> channel3 = new HashMap<>();
        channel3.put("payTypeId", "4");
        channel3.put("payChannelName", "佰富支付支付寶話費");
        channel3.put("payPlatformCode", "100BAIFUZMK");
        channel3.put("payChannelCode", "9002");

        channels.add(channel1);
        channels.add(channel2);
        channels.add(channel3);

        Map<String, Object> variables = new HashMap<>();
        variables.put("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        variables.put("companyCode", "318");
        variables.put("channels", channels);

        // 生成 SQL 文件
        ThymeleafSqlGenerator generator = new ThymeleafSqlGenerator();
        String filePath = "C:/Users/Administrator/Desktop/generate-sql/" + variables.get("companyCode") + ".sql";
        generator.generateSqlFile(filePath, variables);
    }
}

