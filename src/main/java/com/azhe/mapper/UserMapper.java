package com.azhe.mapper;

import com.azhe.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper  {

    public List<User> selectAll();
}
