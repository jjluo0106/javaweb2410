
package leetcode;

import org.junit.Test;


/**
 Example 1:

 Input: nums = [1,1,2]
 Output: 2, nums = [1,2,_]
 Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).
 Example 2:

 Input: nums = [0,0,1,1,1,2,2,3,3,4]
 Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class A026_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int slow = 0;

        for(int fast =0; fast < nums.length; fast++){
            if(nums[fast] != nums[slow]){
                nums[slow++] = nums[fast];

            }
        }
        return ++slow;

    }

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        // 打印修改后的数组（可选）
        for (int i = 0; i < removeDuplicates(nums); i++) {
            System.out.print(nums[i] + " ");
        }
    }
}