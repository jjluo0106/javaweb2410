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
        HttpResponse response = null;
        try {
            String domain = JSONUtil.parseObj(data).get("appDomain").toString();
            String suffix = "/pay/maxid/findMaxId";
            String url = domain + suffix;

            log.info("發送 GET 請求 : {}", url);
            response = HttpRequest.get(url).execute();

            String body = response.body();
            log.info("響應: {}", body);
            return body;
        } catch (Exception e) {
            log.error("獲取最大值信息時發生錯誤: \n{}\n{}", e.getMessage(), e);
            return "{\"status\":0,\"msg\":\"獲取 " +data+ " 最大值信息時發生錯誤 : \n"+ e +"\"}";
        }
    }

}
