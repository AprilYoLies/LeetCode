package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-18
 * @Email g863821569@gmail.com
 */
public class Solution377 {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    dp[i] += 1;
                else if (i - nums[j] >= 1)
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1}, 4));
    }
}
