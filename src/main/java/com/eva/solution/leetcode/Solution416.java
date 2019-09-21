package com.eva.solution.leetcode;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-08-16
 * @Email g863821569@gmail.com
 */
public class Solution416 {
    private static boolean canPartitionDP(int[] nums) {
        if (nums.length == 0)
            return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        int half = sum / 2;
        boolean[][] dp = new boolean[nums.length][half + 1];
        for (int i = 1; i < half + 1; i++) {
            dp[0][i] = nums[0] == i;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < half + 1; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][half];
    }

    private static boolean canPartitionMinSpace(int[] nums) {
        if (nums.length == 0)
            return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        for (int i = 1; i < half + 1; i++) {
            dp[i] = nums[0] == i;
            if (dp[i])
                break;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = half; j >= 1 && j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[half];
    }

    public static boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) return false;
        return dfs(nums.length - 1, 0, target, nums);
    }

    private static boolean dfs(int cur, int sum, int target, int[] nums) {
        for (int i = cur; i >= 0; i--) {
            sum += nums[i];
            if (sum == target) return true;
            else if (sum > target) {
            } else {
                if (dfs(i - 1, sum, target, nums)) return true;
            }
            sum -= nums[i];
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(canPartitionMinSpace(new int[]{100, 100, 100, 100, 100, 100, 100}));
    }
}
