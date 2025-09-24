package com.azhe.mapper;

import com.azhe.pojo.TPayPlatform;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TPayPlatformMapper extends BaseMapper<TPayPlatform>{
    public List<TPayPlatform> queryTest4(String ZFs) ;
}
