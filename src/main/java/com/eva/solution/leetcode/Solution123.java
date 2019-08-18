package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-18
 * @Email g863821569@gmail.com
 */
public class Solution123 {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int len = prices.length;
        int k = 2;
        int[][][] dp = new int[len + 1][k + 1][2];
        dp[1][1][0] = 0;
        dp[1][1][1] = -prices[0];
        dp[1][2][0] = 0;
        dp[1][2][1] = -prices[0];
        for (int i = 2; i < len + 1; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[len][k][0];
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit1(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
