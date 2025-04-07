package leetcode;

public class A121BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        if(prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int price : prices){
            if( minPrice > price) minPrice = price;
            int tempProfit = price-minPrice;
            if(tempProfit>maxProfit) maxProfit=tempProfit;

        }
        return maxProfit;
    }


}
