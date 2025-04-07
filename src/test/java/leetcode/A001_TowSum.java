package leetcode;

import java.util.*;

/**
 Example 1:

 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 Example 2:

 Input: nums = [3,2,4], target = 6
 Output: [1,2]
 Example 3:

 Input: nums = [3,3], target = 6
 Output: [0,1]
 */
public class A001_TowSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];

            if(map.containsValue(target - num)) return new int[]{i, map.get(i)};
            map.put(i, num);
        }
        return new int[]{0};
    }




    public static void main(String[] args) {

        int[] nums = {3,2,4};
        int target =  6;

        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

//    public static int[] twoSum(int[] nums, int target) {
////        System.out.println(0);
//        for(int i=0; i<nums.length-1; i++){
////            System.out.println(1);
//            if(nums[i]>= target-1) continue;
////            System.out.println(2);
//
//            for(int j=i+1; j< nums.length; j++){
//                System.out.println("nums[i] + nums[j] : " + nums[i] + nums[j]);
//                if(nums[i] + nums[j] == target){
//                    return new int[] { i, j};
//                }
//            }
//        }
//
//        return  new int[] {0};
//    }



    }

