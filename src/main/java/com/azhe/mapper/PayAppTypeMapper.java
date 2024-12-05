package com.azhe.mapper;

import com.azhe.pojo.PayAppType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayAppTypeMapper {

//    在test4庫中模糊搜尋盤口
    List<PayAppType> findTest4AppByAppCode(PayAppType payAppType);
}
