// Problem Statement Link :- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
/*
Solution & Explanation for - 122. Best Time to Buy and Sell Stock II

There are multiple ways to solve this question, but the most optimal one is this one-pass solution.

In this solution, we are trying to buy the stock if the previous day's price is lower than the current price. We will buy the stock at the previous price and sell it today to make a profit. If we repeat this for all such days (where the current price is higher than the previous day's price), we can add all the profits to get the total profit.

For example:
If Input is prices = [7,1,5,3,6,4]
Let us assume the day is represented by the array indexes
Then on day 2, the current price is 5 and on the previous day (day 1) the price is 1. This matches our criteria. Profit will be 5-1 = 4.
Then on day 4, the current price is 6 and on the previous day (day 3) the price is 3. This matches our criteria. Profit will be 6-3 = 3.
No other pair of consecuitive days match the our crtiteria prices[i - 1] < prices[i]
Total Profit = 4 + 3 = 7.

Time Complexity: O(N) --> N is length of the input price array
Space Complexity: O(1) --> Constant Space
*/

class Solution {
public:
    int maxProfit(vector<int>& P) {
        int n = size(P), i = 1, profit = 0, buy, sell;
        while(i < n) {
            // find lowest price to buy - local valley 📉
            for(buy = P[i-1]; i < n && P[i] < buy; i++) 
                buy = P[i];    
            if(i >= n) break;      // break if no more days remaining
            // find highest price to sell - local peak  📈 
            for(sell = P[i]; i < n && sell <= P[i]; i++)
                sell = P[i];    
            profit += sell - buy; // keep adding the 💸
            i++;
        }
        return profit;
    }
};

