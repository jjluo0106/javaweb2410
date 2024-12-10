package com.azhe.service;

import com.azhe.mapper.Pay4ListsMapper;
import com.azhe.pojo.PayMethod;
import com.azhe.vo.PayPlatformAndModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Pay4ListsService {


    @Autowired
    Pay4ListsMapper pay4ListsMapper;

    public List<PayPlatformAndModelVO> selModelByEng(PayPlatformAndModelVO payPlatformAndModelVO) {
        System.out.println(123);

        try {
            System.out.println(pay4ListsMapper.selZFsByFuzzy(payPlatformAndModelVO));
            System.out.println(321);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return pay4ListsMapper.selZFsByFuzzy(payPlatformAndModelVO);
    }

    public List<PayMethod> selectByCode(Map<String, Object> requestBody) {


        return null;
    }
}
