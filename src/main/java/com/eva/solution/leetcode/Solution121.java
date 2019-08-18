package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-18
 * @Email g863821569@gmail.com
 */
public class Solution121 {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int max = 0;
        for (int i = 0, pre = prices[i]; i < prices.length - 1; i++) {
            if (pre < prices[i] || pre >= prices[i + 1]) {
                pre = prices[i + 1];
                continue;
            }
            pre = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max)
                    max = prices[j] - prices[i];
            }
        }
        return max;
    }

    public static int maxProfitDp(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length + 1][2];
        dp[1][1] = -prices[0];
        for (int i = 2; i < prices.length + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
        }
        return dp[prices.length][0];
    }

    public static int maxProfitDpLessSpace(int[] prices) {
        if (prices.length == 0)
            return 0;
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        for (int i = 2; i < prices.length + 1; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i - 1]);
            dp_i_1 = Math.max(dp_i_1, -prices[i - 1]);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1, 4}));
        System.out.println(maxProfitDp(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
