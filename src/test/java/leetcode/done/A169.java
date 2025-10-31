package leetcode.practicing;

public class A169 {


    public static int majorityElement(int[] nums) {

        int count = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(count==0) temp  =nums[i];
            count += temp==nums[i] ? 1 : -1;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,2};

        System.out.println(majorityElement(arr));
    }
}
