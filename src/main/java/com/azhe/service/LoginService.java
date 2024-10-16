package com.azhe.service;

import com.azhe.mapper.UserMapper;
import com.azhe.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Service
public class LoginService {
@Autowired
    UserMapper userMapper;



    public List<User> selectAll(){
        return userMapper.selectAll();
    }


/*
判斷登入是否正確
 */
    public ResponseEntity<String> dealLogin(@RequestParam String username,
                                            @RequestParam String password,
                                            @RequestParam String captcha,
                                            HttpServletRequest request){

        String dataBasepassword = "password";

        // 從 Session 中獲取驗證碼
        HttpSession session = request.getSession();
        String sessionCaptcha = (String) session.getAttribute("captchaCode");

        // 記錄輸入信息
        log.info("系統登入資訊 -Captcha: {}",sessionCaptcha);
        log.info("用戶輸入登入資訊 - Username: {}, Password: {}, Captcha: {}", username, password, captcha);


        // 驗證邏輯
        if (sessionCaptcha == null || !sessionCaptcha.equals(captcha)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false, \"message\": \"驗證碼錯誤\"}");
        } else {
            List<User> users = selectAll();

            System.out.println(users);

            boolean flagName = false;

            for (int i = 0; i < users.size(); i++) {
                if(username.equals(users.get(i).getName())){
                    flagName = true;

                    dataBasepassword = users.get(i).getPassword();
                    log.info("此用戶密碼是 : " +dataBasepassword);
                }
            }
            if (!flagName) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false, \"message\": \"查無用戶\"}");
            } else if (!password.equals(dataBasepassword)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false, \"message\": \"密碼錯誤\"}");
            } else {
                return ResponseEntity.ok("{\"success\": true}");
            }
        }
    }
}
