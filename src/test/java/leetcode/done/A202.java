package leetcode.done;

import java.util.HashSet;
import java.util.Set;

public class A202 {

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            set.add(n);
            n = getNext(n);
        }


        return n==1;
    }


    public int getNext(int n){
        int sum = 0;

        while(n!=0){
            int temp = n%10;
            sum += temp * temp;
            n /=10;
        }
        return sum;
    }


}
