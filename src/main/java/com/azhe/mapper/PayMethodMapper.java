package com.azhe.mapper;

import com.azhe.pojo.PayMethod;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMethodMapper {
    public List<PayMethod> selectByCode(String payMethodCode) ;
}
