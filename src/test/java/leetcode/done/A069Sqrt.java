package leetcode.done;


/**
 Example 1:

 Input: x = 4
 Output: 2
 Explanation: The square root of 4 is 2, so we return 2.
 Example 2:

 Input: x = 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */

public class A069Sqrt {

    public int mySqrt(int x) {

        if(x<=1)return x;

        int a = 0;
        int b = x;


        while(a<=b){
            int mid = (a+b)/2;

            if(mid==x/mid) return mid;
            if(mid> x/mid) b = mid-1;
            if(mid< x/mid) a = mid+1;
        }
        return b;
    }


}
