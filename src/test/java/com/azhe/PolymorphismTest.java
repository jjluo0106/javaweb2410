package com.azhe;

import org.junit.jupiter.api.Test;

public class PolymorphismTest {


    @Test
    public void test() throws MyException{


        int num = 0;

        try {
            System.out.println(5/0);
        } catch (Exception e) {
            System.out.println("catch");
//            throw new RuntimeException(e);
        }

        System.out.println("end");

    }


}

class MyException extends RuntimeException {
    public MyException(String message){
        super(message + "666");
        System.out.println(123);
    }

}


