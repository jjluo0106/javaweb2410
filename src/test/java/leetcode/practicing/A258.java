package leetcode.practicing;

public class A258 {



    public int addDigits(int num) {


        if(num/10==0) return num;

        int sum =0;


        while(num!=0){
            int temp = num%10;
            sum += temp;
            num /=10;
        }
        return addDigits(sum);
    }
}
