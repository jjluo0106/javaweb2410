package com.azhe.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayLevelRelationMapper {

    public List<Integer> selAllLevelID();
    public List<Integer> selAllMemberVipID();

    public List<Integer> selAllDevice();

}
