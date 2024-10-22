package com.azhe.service;

import com.azhe.mapper.BrandMapper;
import com.azhe.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {


    @Autowired
    BrandMapper brandMapper;

    public List<Brand> selectAll(){

        return brandMapper.selectAll();
    }

    public int add(Brand brand) {
        return brandMapper.add(brand);
    }

    public int update(Brand brand) {
        return   brandMapper.update(brand);
    }

    public int deleteById(Brand brand) {
        return brandMapper.deleteById(brand);
    }
}
