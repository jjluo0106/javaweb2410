package com.azhe.controller;
import com.azhe.pojo.PayRequestModel;
import com.azhe.service.Pay4ListsService;
import com.azhe.vo.PayPlatformAndModelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
public class Pay4ListsController {
    @Autowired
    Pay4ListsService pay4ListsService;


    @PostMapping("/selModelByEng")
    public List<PayPlatformAndModelVO> selModelByEng(@RequestBody PayPlatformAndModelVO payPlatformAndModelVO) {
        log.info("請求體 : {}",payPlatformAndModelVO);
        log.info(pay4ListsService.selModelByEng(payPlatformAndModelVO).toString());
        return pay4ListsService.selModelByEng(payPlatformAndModelVO);
    }
}
