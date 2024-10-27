package com.azhe.mapper;

import com.azhe.pojo.PayPlatform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlatformMapper {
    public List<PayPlatform> queryTest4() ;
}
