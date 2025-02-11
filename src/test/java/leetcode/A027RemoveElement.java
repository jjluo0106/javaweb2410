package leetcode;

import java.util.Arrays;


/**
 * 返回除了tal的字串長度，並將此長度的數組進行排序
 */

public class A027RemoveElement {

    public int removeElement(int[] nums, int val) {

        int slow =0;

        for(int fast =0; fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[++slow] = nums[fast];
            }
        }
        return ++slow;
    }


    public static void main(String[] args) {

        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(new A027RemoveElement().removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

}
