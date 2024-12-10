package com.azhe.mapper;

import com.azhe.pojo.PayMethod;
import com.azhe.pojo.PayRequestModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayRequestModelMapper {
    public List<PayRequestModel> selectByCode(String payMethodCode) ;
}
