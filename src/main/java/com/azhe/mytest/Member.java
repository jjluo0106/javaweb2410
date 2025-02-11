package com.azhe.mytest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {


    private String numberName; // 出資人
    private int totalAmount; // 出資總金額
    private int weight; // 權重
    

}
