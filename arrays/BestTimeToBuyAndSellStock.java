package arrays;

class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];  // lowest buy price seen so far
        int maxProfit = 0;         // best profit seen so far

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];  // found cheaper buy price
            }

            int profit = prices[i] - minPrice;  // profit if sold today

            if (profit > maxProfit) {
                maxProfit = profit;  // update best profit
            }
        }

        return maxProfit;
    }
}
