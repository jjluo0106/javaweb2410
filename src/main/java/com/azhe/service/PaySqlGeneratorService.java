package com.azhe.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.dialect.Props;
import com.azhe.mapper.*;
import com.azhe.pojo.*;
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
public class PaySqlGeneratorService {

    private final TemplateEngine templateEngine;

    @Autowired
    PlatformMapper platformMapper;
    @Autowired
    PayChannelMapper payChannelMapper;
    @Autowired
    PayMethodMapper payMethodMapper;
    @Autowired
    PayRequestModelMapper payRequestModelMapper;
    @Autowired
    MemberPayFiledMapper memberPayFiledMapper;

    @Autowired
    PayLevelRelationMapper payLevelRelationMapper;

    public PaySqlGeneratorService() {
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
            log.info("原始数据字符串:\n{}", rawRequestBody);
            JSONObject rJSON = JSONUtil.parseObj(rawRequestBody);
            log.info("解析字串:\n{}", JSONUtil.parseObj(rawRequestBody).toStringPretty());

            //*****************前端部分資訊

            // 提取 ZFs 并转为 List **目前禁止使用兩個支付導出！！會跟　修改導出　衝突　（到時候可能兩個就不使用修改導出）
            JSONArray zfsArray = rJSON.getJSONArray("zfs");
            List<String> zfsList = zfsArray.toList(String.class);
            zfsList = CollUtil.map(zfsList, item -> "'" + item + "'", true);
            // 提取 modifier
            JSONObject modifier = (JSONObject) rJSON.get("modifier");
            log.info("modifier :\n{}", modifier);
            // 提取 apps
            JSONArray apps =  rJSON.getJSONArray("apps");
            log.info("apps :\n{}", apps);

            //*****************資料庫部分資訊
            List<PayPlatform> payPlatforms = platformMapper.queryTest4(CollUtil.join(zfsList, ", "));
            List<PayMethod> payMethods = payMethodMapper.selectByCode(zfsList.get(0));
            List<PayChannel> payChannels = payChannelMapper.selectByCode(zfsList.get(0));
            List<PayRequestModel> payRequestModels = payRequestModelMapper.selectByCode(zfsList.get(0));
            List<MemberPayFiled> memberPayFiledMappers = memberPayFiledMapper.selectByModelId(payRequestModels.get(0).getPayModelId().toString());


            log.info("modifier: {}" , modifier);

            System.out.println(payRequestModels);

            // 使用 modifier修改 payPlatforms
            useModifier(modifier, payPlatforms);

            payPlatforms.get(0).setPayPlatformId(String.valueOf(rJSON.getByPath("apps[0].platformId", Integer.class) + 1)); // getByPath是hutool 的路徑表達式


            payMethods.get(0).setPayMethodId(String.valueOf(rJSON.getByPath("apps[0].methodId", Integer.class) + 1));
            payMethods.get(0).setMyPlatformCode(modifier.get("myPlatformCode").toString());
            payMethods.get(0).setMyPlatformName(modifier.get("myPlatformName").toString());
            payMethods.get(0).setMyChannelCode(modifier.get("myChannelCode").toString());

            payChannels.get(0).setPayChannelId(String.valueOf(rJSON.getByPath("apps[0].channelId", Integer.class) + 1));
            payChannels.get(0).setPayMethodId(String.valueOf(rJSON.getByPath("apps[0].methodId", Integer.class) + 1));
            payChannels.get(0).setMyChannelCode(modifier.get("myChannelCode").toString());
            payChannels.get(0).setMyPlatformName(modifier.get("myPlatformName").toString());
            payChannels.get(0).setMyPlatformCode(modifier.get("myPlatformCode").toString());

            payRequestModels.get(0).setPayModelId(String.valueOf(rJSON.getByPath("apps[0].modelId", Integer.class) + 1));
            payRequestModels.get(0).setMyChannelCode(modifier.get("myChannelCode").toString());
            payRequestModels.get(0).setMyPlatformName(modifier.get("myPlatformName").toString());
            payRequestModels.get(0).setMyPlatformCode(modifier.get("myPlatformCode").toString());
            payRequestModels.get(0).setMySuccessfulURL(modifier.get("mySuccessfulURL").toString());
            payRequestModels.get(0).setMyCallbackURL(modifier.get("myCallbackURL").toString());


            memberPayFiledMappers.forEach( file ->{
                file.setPayModelId(String.valueOf(rJSON.getByPath("apps[0].modelId", Integer.class) + 1) );
            });

//            memberPayFiledMappers.get(0).setPayModelId(String.valueOf(rJSON.getByPath("apps[0].modelId", Integer.class) + 1) );


            map.put("payPlatforms", payPlatforms);
            map.put("payMethods", payMethods.get(0));
            map.put("payChannels", payChannels.get(0));
            map.put("payRequestModels", payRequestModels);
            map.put("mappers", memberPayFiledMappers);
            map.put("levelIDs",payLevelRelationMapper.selAllLevelID());
            map.put("memberVipIDs",payLevelRelationMapper.selAllMemberVipID());
            map.put("devices",payLevelRelationMapper.selAllDevice());
//            context.setVariable("payPlatforms", payPlatforms);
            // 將所需的參數map傳遞給腳本
            context.setVariables(map);
            // 生成 SQL 文件內容 指定template腳本
            String content = templateEngine.process("myScript", context);



            // 選擇路徑並寫入文件
            StringBuffer locattion = null;
            locattion = new StringBuffer(new Props("application.properties").
                    get("azhe.sql.payGenerateLocation").toString()).
                    append((new Date().getMonth() + 1) + "月\\" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "\\").
                    append(modifier.get("myPlatformName")).
                    append(new SimpleDateFormat("HHmm").format(new Date())).append(".sql");


            File file = new File(locattion.toString());
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

            log.info("腳本成功生成:\n{}", locattion.toString());

            try {
                // 自動開啟文件
                String folderPath = locattion.toString();
                Runtime.getRuntime().exec("explorer.exe " + folderPath);
                log.info("資料夾已打開");
            } catch (Exception e) {
                log.info("打開資料夾失敗");
            }


            return locattion.toString();
        } catch (RuntimeException e) {
            log.info("錯誤 :\n{}", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 自定義導出的一些修改參數
     *
     * @param modifier
     * @param payPlatforms
     */
    private static void useModifier(JSONObject modifier, List<PayPlatform> payPlatforms) {
        payPlatforms.forEach(
                platform -> {
                    log.info("payPlatformId: {}", platform.getPayPlatformId());

//                    platform.setPayPlatformId(platform.getPayPlatformId() + 1);

                    platform.setMyPlatformName(modifier.get("myPlatformName").toString());
                    platform.setMyPlatformCode(modifier.get("myPlatformCode").toString());
                    platform.setMyMerchantCode(modifier.get("myMerchantCode").toString());
                    platform.setMySecretCode(modifier.get("mySecretCode").toString());

                    platform.setMyIP(modifier.get("myIP").toString());
                    platform.setMySuccessfulURL(modifier.get("mySuccessfulURL").toString());
                    platform.setMyQueryURL(modifier.get("myQueryURL").toString());
                    platform.setMyChannelCode(modifier.get("myChannelCode").toString());
                }
        );
    }

}

