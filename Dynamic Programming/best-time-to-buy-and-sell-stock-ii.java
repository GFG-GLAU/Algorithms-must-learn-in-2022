/*
Problem Link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
Solution - In this problem on each day I am checking if we are getting the profit then I am selling the stock otherwise we will not consider.
  
*/

class Solution {
    public int maxProfit(int[] prices) {
        int curr = 0;
        for (int i =0; i < prices.length-1; i++){
            curr = Math.max(curr,curr+(prices[i+1]-prices[i]));
        }
        return curr;
    }
}
