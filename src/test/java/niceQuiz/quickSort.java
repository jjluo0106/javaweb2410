package niceQuiz;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import org.junit.jupiter.api.Test;

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



    @Test
    public void testtt(){



        Movie m1 = new Movie("電影一");
        Movie m2 = new Movie("電影二");
        Movie m3 = new Movie("電影三");

        Movie[] mo = new Movie[3];
        mo[0] = m1;
        mo[1] = m2;
        mo[2] = m3;

        MovieOperator moo = new MovieOperator(mo);

        System.out.println(moo.toString());


    }




    public class MovieOperator{
        private Movie[] movies;

        public MovieOperator(Movie[] movies){
            this.movies =movies;
        }

        public void printMovie(){
            System.out.println(movies);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (Movie movie : movies) {
                sb.append(movie.name + "，");
            }
            return sb.toString();
        }
    }
}
