package com.azhe.controller;

import com.azhe.pojo.PayRequestModel;
import com.azhe.service.Pay4ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Pay4ListsController {
    @Autowired
    Pay4ListsService pay4ListsService;


    @PostMapping("/selModelByEng")
    public List<PayRequestModel> selModelByEng(PayRequestModel model) {
        return pay4ListsService.selModelByEng(model);
    }
}
