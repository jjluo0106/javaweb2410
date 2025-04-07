package leetcode;

import cn.hutool.core.lang.hash.Hash;

import java.util.*;

public class A136SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums.length==0) return 0;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        return set.iterator().next();
    }
}
