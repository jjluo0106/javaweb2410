package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class A168 {


    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while(columnNumber!=0){
            columnNumber-=1;
            sb.append( (char)('A' + columnNumber%26 ) );
            columnNumber/=26;

        }
        return sb.reverse().toString();
    }


    @Test
    public void test(){
        List list = new ArrayList();
        for(int i=0; i<26; i++){
            list.add( (char) ('A'+i));
        }

        System.out.println(list);
    }
}
