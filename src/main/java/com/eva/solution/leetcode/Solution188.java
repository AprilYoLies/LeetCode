package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-18
 * @Email g863821569@gmail.com
 */
public class Solution188 {
    public static int maxProfit(int k, int[] prices) {
        if (prices.length <= 1)
            return 0;
        if (k > (prices.length / 2)) {
            return maxProfitInfinite(prices);
        }
        int[][][] dp = new int[prices.length + 1][k + 1][2];
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                }
            }
        }
        return dp[prices.length][k][0];
    }

    private static int maxProfitInfinite(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i < prices.length + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
