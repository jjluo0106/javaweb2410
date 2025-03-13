package leetcode;


import org.junit.Test;

/**
 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */

public class A067AddBinary {


    public String addBinary(String a, String b) {
        int carry =0, i = a.length(), j = b.length();
        StringBuilder sb = new StringBuilder();
        while(i > 0 || j > 0 || carry > 0){
            if(i > 0) carry += a.charAt(--i) - '0';
            if(j > 0) carry += b.charAt(--j) - '0';
            sb.append(carry %2);
            carry /=2;
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        System.out.println(addBinary("11", "1"));
    }
}
