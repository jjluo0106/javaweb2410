package leetcode.done;


/**
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class A070ClimbingStairs {

    public int climbStairs(int n) {

        if(n<=2) return n;

        int temp = 0;
        int a = 1;
        int b = 2;
        for(int i=3; i<=n; i++){

           temp = a + b;
           a = b;
           b = temp;
        }
        return temp;

    }


}
