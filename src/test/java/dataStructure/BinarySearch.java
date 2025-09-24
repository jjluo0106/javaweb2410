package dataStructure;

import org.junit.jupiter.api.Test;

import static dataStructure.TestStop.myStop;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        int ans = binarySearch(arr, target);


        System.out.println(ans);
    }


    static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int half = (left + right) / 2;
        while(left<=right){
            System.out.println("left:"+left+" right:"+right+" half:"+half);

            if (target > arr[half]) {
                left = half + 1;
                half = (left + right) / 2;
                continue;
            }else if(target < arr[half]){
                right = half - 1;
                half = (left + right) / 2;
                continue;
            }
            return half;
        }
        return -1;

    }

    @Test
    public void test() {
        assertEquals(binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 5), 4);
        myStop();

    }


    // 靜態方法來測量其他方法的執行時間
    public static void measureExecutionTime(Class c) {


        Class<?> clazz = c.getClass();

    }
}
