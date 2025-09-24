package com.azhe;

import com.azhe.mapper.PayRequestModelMapper;
import com.azhe.mapper.TPayPlatformMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//加載 Spring Boot 應用的上下文，並注入測試所需的依賴
@SpringBootTest
//告訴 JUnit 使用 Spring 提供的運行器來執行測試
//@RunWith(SpringRunner.class)
public class MySpringTest {
    @Autowired
    PayRequestModelMapper payRequestModelMapper;


    @Value("${spring.application.name}")
    private String appId;

    @Test
    public void test1() {
        System.out.println(payRequestModelMapper.selectByCode("'ABPAY255ZF'"));
    }



    @Autowired
    TPayPlatformMapper tPayPlatformMapper;
    @Test
    public void selectById(){
//        System.out.println(userMapper.selectById(4));
//        System.out.println(platformMapper.queryTest4("ZF"));
//        System.out.println("pay4ListsMapper = " + pay4ListsMapper);
//
//        PayPlatformAndModelVO payPlatformAndModelVO = new PayPlatformAndModelVO();
//        System.out.println(pay4ListsMapper.selectModelByInputBoxes(payPlatformAndModelVO));

        tPayPlatformMapper.selectById(6000);
    }
}
