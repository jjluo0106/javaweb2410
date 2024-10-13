package com.azhe.controller;

import com.azhe.pojo.Brand;
import com.azhe.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

@Autowired
    BrandService brandService;




    @RequestMapping("/add")
    public int add(Brand brand){

        int add = brandService.add(brand);
        System.out.println(add);

        System.out.println("新增brand");
        System.out.println(brandService.selectAll());

        return add;
    }

    @RequestMapping("/delete")
    public void delete(Brand brand){
        System.out.println("刪除");
    }


    @RequestMapping("/update")
    public void update(@RequestBody Brand brand){


        System.out.println(brand);

        brandService.update(brand);
        System.out.println("修改");

        System.out.println(brandService.selectAll());
    }



    @RequestMapping("/selectAll")
    public List<Brand> selectAll(){
        return brandService.selectAll();
    }
}
