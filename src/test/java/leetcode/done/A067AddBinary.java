package leetcode.done;



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


        int aPointer = a.length()-1;
        int bPointer = b.length()-1;
        int sum  = 0;
        StringBuilder sb = new StringBuilder();

        while(aPointer>-1 || bPointer>-1 || sum!=0){

            if(aPointer>-1) sum+= a.charAt(aPointer--) - '0';
            if(bPointer>-1) sum+= b.charAt(bPointer--) - '0';
            sb.append(sum%2);
            sum/=2;
        }
        return sb.reverse().toString();
    }


}
