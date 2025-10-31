package leetcode.practicing;

import java.util.HashMap;
import java.util.Map;

public class A205 {


    public boolean isIsomorphic(String s, String t) {

        int sI = getI(s);
        int tI = getI(t);
        return sI==tI;


    }

    public int getI(String str){

        int count = 1;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)) { map.put(c, count++); }
            result = result*10 +map.get(c);

        }
        return result;

    }



}