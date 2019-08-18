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

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
    }
}
