package com.azhe.mapper;

import com.azhe.pojo.PayChannel;
import com.azhe.pojo.PayMethod;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayChannelMapper {
    public List<PayChannel> selectByCode(String payMethodCode) ;
}
