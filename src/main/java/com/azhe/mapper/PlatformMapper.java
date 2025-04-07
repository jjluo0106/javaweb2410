package com.azhe.mapper;

import com.azhe.pojo.PayPlatform;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlatformMapper extends BaseMapper<PayPlatform> {
    public List<PayPlatform> queryTest4(String ZFs) ;
}
