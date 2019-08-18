package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-18
 * @Email g863821569@gmail.com
 */
public class Solution122 {
    // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + price[i])
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int i = 1; i < prices.length + 1; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0)
                    dp[i][j] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                else
                    dp[i][j] = Math.max(dp[i - 1][0] - prices[i - 1], dp[i - 1][1]);
            }
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
