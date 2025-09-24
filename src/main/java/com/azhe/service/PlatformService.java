package com.azhe.service;

import com.azhe.mapper.TPayPlatformMapper;
import com.azhe.pojo.TPayPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    @Autowired
    TPayPlatformMapper platformMapper;
    public List<TPayPlatform> queryTest4(String ZF) {
        return platformMapper.queryTest4(ZF);
    }

//    public PayPlatform selectById(int id) {
//        return  platformMapper.selectById(id);
//    }
}
