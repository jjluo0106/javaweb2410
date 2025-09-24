package com.azhe;

import org.junit.jupiter.api.Test;

public class TestStructure {


@Test
    public void test(){
    Ji ji = new Ji();
    System.out.println(123);


    System.out.println(ji.name);
    System.out.println(ji.faName);
}



}



class Fu{
//     Fu(){
//        System.out.println("執行父親無參數");
//    };
String name = "爸";
}

class Ji extends Fu{
    Ji(){
        System.out.println("執行子親無參數");
    }
    String name = "兒";
    String faName = super.name;

}
