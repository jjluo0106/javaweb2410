package com.azhe.service;

import com.azhe.mapper.PlatformMapper;
import com.azhe.pojo.PayPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    @Autowired
    PlatformMapper platformMapper;
    public List<PayPlatform> queryTest4(String ZF) {
        return platformMapper.queryTest4(ZF);
    }

    public PayPlatform selectById(int id) {
        return  platformMapper.selectById(id);
    }
}
