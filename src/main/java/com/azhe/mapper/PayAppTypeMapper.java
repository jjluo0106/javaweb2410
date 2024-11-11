package com.azhe.mapper;

import com.azhe.pojo.PayAppType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayAppTypeMapper {

    List<PayAppType> findTest4AppByAppCode(PayAppType payAppType);
}
