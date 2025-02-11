package com.azhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
// 請根據您的 Mapper 包路徑修改
public class PayToolStarter {

    public static void main(String[] args) {
        try {
            SpringApplication.run(PayToolStarter.class, args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1); // 檢查是否有這類程式碼
        }
    }


}
