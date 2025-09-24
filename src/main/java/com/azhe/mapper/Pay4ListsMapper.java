package com.azhe.mapper;

import com.azhe.vo.PayPlatformAndModelVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Pay4ListsMapper extends BaseMapper<PayPlatformAndModelVO> {

//    public List<PayRequestModel> selectAll();

    List<PayPlatformAndModelVO> selectModelByInputBoxes(PayPlatformAndModelVO payPlatformAndModelVO);
}
