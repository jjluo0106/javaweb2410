package com.azhe.mytest;

import org.junit.Test;

import java.util.*;

public class testClass {


    @Test
    public void test(){

        String[] strs = {"ab", "a"};

        String s = longestCommonPrefix(strs);

        System.out.println("結果 : " + s);




    }

    private String longestCommonPrefix(String[] strs) {

        if(strs.length ==0 || strs == null) return "";

        String first = strs[0];

        for(int i = 0; i < first.length() ; i++){ // 判斷第i個字是否一樣
            char c = first.charAt(i);

            for(int j =1; j < strs.length; j++){ // 判斷第j個數組字串
                if(  strs[j].length() <= i || strs[j].charAt(i) != c ) return first.substring(0, i);
            }

        }

        return first;
    }


}







