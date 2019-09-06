package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-09-06
 * @Email g863821569@gmail.com
 */
public class Solution486 {
    public static boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (j < i) continue;
                if (i == j) dp[i][j] = nums[i];
                else {
                    if (i == len - 1) dp[i][j] = nums[i];
                    else dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
}
