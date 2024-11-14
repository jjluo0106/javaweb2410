package com.azhe.service;

import com.azhe.mapper.Pay4ListsMapper;
import com.azhe.pojo.PayRequestModel;
import com.azhe.vo.PayPlatformAndModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Pay4ListsService {

    @Autowired
    Pay4ListsMapper pay4ListsMapper;

    public List<PayPlatformAndModelVO> selModelByEng(PayPlatformAndModelVO payPlatformAndModelVO) {
        return pay4ListsMapper.selModelByEng(payPlatformAndModelVO);
    }
}
