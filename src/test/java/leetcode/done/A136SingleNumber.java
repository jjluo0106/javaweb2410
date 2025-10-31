package leetcode.done;

import java.util.HashSet;
import java.util.Set;

public class A136SingleNumber {

    public int singleNumber(int[] nums) {

        Set<Integer> s = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(s.contains(nums[i])) s.remove(nums[i]);
            else s.add(nums[i]);
        }
        return s.iterator().next();

    }
}
