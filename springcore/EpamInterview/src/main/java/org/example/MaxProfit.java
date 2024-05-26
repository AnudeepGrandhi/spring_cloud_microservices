package org.example;

// The goal is to find the best time to buy and sell a stock to maximize
// profit given an array of stock prices representing each day's closing price.
    //purchase at day 2 and sell at day 7 and your profit is 70
//            purchase at day 8 and sell at day 9 and your profit is 150
public class MaxProfit {

    public void findMaxProfitDays(int[] price) {


        for(int i=0;i<price.length-2;i++) {
            int maxProfit=0;
            int previousProfit = 0;
            int buyday = 0;
            int buy = 0;
            int sell =0;
            int sellday = 0;
            if (price[i] < price[i+1]) {
                buyday = i;
                buy = price[i];
                if(buy > price[i-1]) {
                    buyday = i;
                    buy = price[i];
                }
                sellday = i+1;
                sell = price[i+1];
                if(sell < price[i+2]) {
                    sellday = i+1;
                    sell = price[i+1];
                }

                previousProfit = previousProfit + (sell - buy);

                System.out.println("purchase at day " +buyday+" and sell at day"+sellday+" and your profit is "+previousProfit);
            }
        }

    }
}
