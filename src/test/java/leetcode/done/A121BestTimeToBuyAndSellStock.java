package leetcode;

public class A121BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int low = prices[0];
        int mProfit= 0;

        for(int i=1; i< prices.length; i++){
            int temp = prices[i];
            if(temp<low) low = temp;
            if(temp-low>mProfit) mProfit = temp-low;

        }
        return mProfit;
    }


}
