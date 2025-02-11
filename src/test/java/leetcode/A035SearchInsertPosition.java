package leetcode;

import org.junit.Test;

public class A035SearchInsertPosition {



    public int searchInsert(int[] nums, int target) {

        int temp = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > target || nums[i] == target) {
                temp = i;
                break;
            }else{
                temp = i+1;
            }
        }
        return temp;
    }



    @Test
    public void test(){

        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));


    }
}
