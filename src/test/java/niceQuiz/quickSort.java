package niceQuiz;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import java.util.Arrays;

public class quickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = arr[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // 遞迴左右區間
        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }


    public static void main(String[] args) {
        int num = 10000;

        int[] arr = new int[num];




        TimeInterval timer = DateUtil.timer();
        quickSort(arr, 0, arr.length - 1);
        long interval = timer.interval();
        System.out.println(Arrays.toString(arr));
        System.out.println("耗時 : " + interval);
    }
}
