/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // int maxProfit = 0;

        // for (int i = 0; i < prices.length - 1; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
        //     }
        // }
        // return maxProfit;
        int min = Integer.MAX_VALUE, max = 0;
        for (int price: prices) {
            min = Math.min(min, price);
            max = Math.max(price - min, max);
        }
        return max;
    }
}
// @lc code=end

