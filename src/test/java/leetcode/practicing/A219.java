package leetcode.practicing;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class A219 {


    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int tempKey = nums[i];
            if(map.containsKey(tempKey) && i-map.get(i) <= k) return true;
            map.put(tempKey, i);
        }
        return false;
    }


    @Test
    public void testttt(){

        Map<Integer, Integer> map = new HashMap<>();


        map.put(1,1);
        map.put(1,2);



    }
}
