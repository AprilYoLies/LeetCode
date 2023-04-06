package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2019-08-18
 * @Email g863821569@gmail.com
 */
public class Solution122 {

    @Test
    public void testSolution() {
        System.out.println(maxProfit(new int[]{1}));
    }

    public int maxProfit(int[] prices) {
        int income = 0;
        int buy = 0;
        boolean hasBuy = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1] && !hasBuy) {
                buy = prices[i - 1];
                hasBuy = true;
            }
            if (hasBuy && (prices[i] < prices[i - 1] || i == prices.length - 1)) {
                int profit = Math.max(prices[i], prices[i - 1]) - buy;
                if (profit > 0) {
                    income += profit;
                }
                hasBuy = false;
            }
        }
        return income;
    }


    // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + price[i])
    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;
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
        System.out.println(maxProfit1(new int[]{1, 2, 3, 4, 5}));
    }
}
