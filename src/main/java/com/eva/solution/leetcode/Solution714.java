package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-19
 * @Email g863821569@gmail.com
 */
public class Solution714 {
    public static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1)
            return 0;
        int[][] dp = new int[prices.length + 1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0] - fee;
        for (int i = 2; i < prices.length + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}