package com.azhe.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.azhe.mapper.PayAppTypeMapper;
import com.azhe.pojo.PayAppType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PayAppTypeService {

    @Autowired
    PayAppTypeMapper payAppTypeMapper;


    public List<PayAppType> findTest4AppByAppCode(PayAppType payAppType) {
        return payAppTypeMapper.findTest4AppByAppCode(payAppType);
    }

    public String getMaxInfo(Object data) {
        String domain = JSONUtil.parseObj(data).get("appDomain").toString(); // 獲取玉明
        String suffix = "/pay/maxid/findMaxId"; // 服務器查詢最大值尾墜
        String url = domain + suffix;

        log.info("發送get請求 : {}",url);
        HttpResponse response = HttpRequest.get(url).execute();

        String body = response.body();
       log.info("響應: {}", body);
        return body;
    }
}
