package com.azhe.service;

import com.azhe.mapper.PayMethodMapper;
import com.azhe.mapper.PlatformMapper;
import com.azhe.pojo.PayMethod;
import com.azhe.pojo.PayPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayMethodService {

    @Autowired
    PayMethodMapper payMethodMapper;
    public List<PayMethod> selectByCode(String payMethodCode) {
        return payMethodMapper.selectByCode(payMethodCode);
    }
}
