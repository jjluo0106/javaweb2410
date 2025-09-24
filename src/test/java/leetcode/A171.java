package leetcode;

import org.junit.jupiter.api.Test;

public class A171 {


    public int titleToNumber(String columnTitle) {
        int num = columnTitle.length();
        int temp = 0;

        for(int i = 0; i==num; i++){
            temp += 26*i -64 + columnTitle.charAt(i);
        }
        return temp;
    }

    @Test
    public void tttt(){
        System.out.println(-64+'A');
    }
}
