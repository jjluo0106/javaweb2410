package leetcode;

import org.junit.jupiter.api.Test;

public class A168 {


    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            sb.insert(0, (char) ('A' + columnNumber%26));
            columnNumber/=26;
        }
        return sb.toString();
    }


    @Test
    public void test(){
        char c= 'A';
        System.out.println(c+0);


        char cc= (27%27+64);
        System.out.println(cc);
    }
}
