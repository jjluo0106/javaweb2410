package leetcode;

import org.junit.Assert;
import org.junit.Test;

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

        int left = 0, right = x, mid = 0;

        while(left <= right){
            mid = left + (right -left)/2;
            if(mid == x/mid) return mid;
            if(mid <  x/mid) left = mid +1;
            else right = mid - 1;
        }
        return right;
    }

    @Test
    public void test(){
//        Assert.assertEquals(2, mySqrt(4));
        Assert.assertEquals(2, mySqrt(8));
        Assert.assertEquals(3, mySqrt(9));
        Assert.assertEquals(3, mySqrt(10));
    }
}
