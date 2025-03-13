package leetcode;

import org.junit.Test;


/**
 Example 1:

 Input: nums = [1,3,5,6], target = 5
 Output: 2
 Example 2:

 Input: nums = [1,3,5,6], target = 2
 Output: 1
 Example 3:

 Input: nums = [1,3,5,6], target = 7
 Output: 4
 */
public class A035SearchInsertPosition {



    public int searchInsert(int[] nums, int target) {

        if(nums == null || nums.length == 0) return 0;

        for(int i=0; i< nums.length; i++){
            if(nums[i] >= target) return i;

        }
        return nums.length;
    }



    @Test
    public void test(){

        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));


    }
}
