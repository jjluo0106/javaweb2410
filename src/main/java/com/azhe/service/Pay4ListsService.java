package com.azhe.service;

import com.azhe.mapper.Pay4ListsMapper;
import com.azhe.mapper.PayMethodMapper;
import com.azhe.pojo.PayMethod;
import com.azhe.pojo.PayRequestModel;
import com.azhe.vo.PayPlatformAndModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Pay4ListsService {

    @Autowired
    Pay4ListsMapper pay4ListsMapper;
    @Autowired
    PayMethodMapper payMethodMapper;

    public List<PayPlatformAndModelVO> selModelByEng(PayPlatformAndModelVO payPlatformAndModelVO) {
        return pay4ListsMapper.selModelByEng(payPlatformAndModelVO);
    }

    public List<PayMethod> selectByCode(Map<String, Object> requestBody) {


        return null;
    }
}
