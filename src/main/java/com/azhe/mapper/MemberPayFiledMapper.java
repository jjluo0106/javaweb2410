package com.azhe.mapper;

import com.azhe.pojo.MemberPayFiled;
import com.azhe.pojo.PayRequestModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberPayFiledMapper {
    List<MemberPayFiled> selectByModelId(String modelId);
}
