package com.azhe.service;

import com.azhe.mapper.Pay4ListsMapper;
import com.azhe.pojo.PayRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Pay4ListsService {

    @Autowired
    Pay4ListsMapper pay4ListsMapper;

    public List<PayRequestModel> selModelByEng(PayRequestModel requestModel) {
        return pay4ListsMapper.selModelByEng(requestModel);
    }
}
