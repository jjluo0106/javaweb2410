package com.azhe.service;


import com.azhe.mapper.UserMapper;
import com.azhe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public List<User> selectAll() {
        return userMapper.selectAll();
    }

//    public User selectById(int id) {
//        return userMapper.selectById(id);
//    }
}
