package leetcode.done;

import org.junit.jupiter.api.Test;

public class A171 {


    public int titleToNumber(String columnTitle) {

        int result = 0;

        for(int i = columnTitle.length()-1; i>=0; i--){
            char c = columnTitle.charAt(i);

            result = result*26 + (c - 'A'+1);
        }
        return result;
    }

    @Test
    public void tttt(){
        System.out.println(-64+'A');
    }
}
