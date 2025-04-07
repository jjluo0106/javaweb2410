package com.azhe;

import com.azhe.mapper.PlatformMapper;
import com.azhe.mapper.UserMapper;
import com.azhe.service.Pay4ListsService;
import com.azhe.service.UserService;
import com.azhe.vo.PayPlatformAndModelVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class MyTest {


    @Value("${spring.datasource.username}")
    private String appId;

    @Test
    public void test1() {
        System.out.println(appId);
    }

    @Test
    public void test2() {

        String aa = "null";

        Optional.ofNullable( aa )
                .orElse("");

    }

    @Autowired
    PlatformMapper platformMapper;
    @Autowired
    Pay4ListsService pay4ListsService;
    @Test
    public void test3(){
//        System.out.println(userMapper.selectById(4));
//        System.out.println(platformMapper.queryTest4("ZF"));

        pay4ListsService.selectModelByInputBoxes(new PayPlatformAndModelVO());
    }
}
