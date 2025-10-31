package leetcode.practicing;

import java.util.ArrayList;
import java.util.List;

public class A228 {

    public List<String> summaryRanges(int[] nums) {

        List<String> list  = new ArrayList<>();
        if(nums==null) return list;
        int start= nums[0];
        for(int i=1; i<=nums.length; i++){
            int end=  nums[i-1];
            if(i==nums.length || nums[i-1]+1 != nums[i]){
                if(start==end) list.add(start + "");
                else list.add(start + "->" + end);
                if(i!=nums.length) start = nums[i-1];
            }

        }
        return list;
    }


    public static void main(String[] args) {
        A228.test();


    }


    public static void test() {

        throw new RuntimeException("avc");
    }

}
