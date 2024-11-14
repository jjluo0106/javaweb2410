package com.azhe.mapper;

import com.azhe.pojo.PayRequestModel;
import com.azhe.pojo.User;
import com.azhe.vo.PayPlatformAndModelVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Pay4ListsMapper {

//    public List<PayRequestModel> selectAll();

    List<PayPlatformAndModelVO> selModelByEng(PayPlatformAndModelVO payPlatformAndModelVO);
}
