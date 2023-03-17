package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2023-03-18 01:21:59
 * @Email g863821569@gmail.com
 */
public class Solution209 {
    // 输入：target = 7, nums = [2,3,1,2,4,3]
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (sum >= target) {
                while (sum - nums[l] >= target) {
                    sum -= nums[l];
                    l++;
                }
                int len = r - l + 1;
                if (min == 0) {
                    min = len;
                } else {
                    if (min > len) {
                        min = len;
                    }
                }
            }
        }
        return min;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int[] dp = new int[nums.length];
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[0] = nums[0];
                    } else {
                        dp[j] = dp[j - 1] + nums[j];
                    }
                } else {
                    if (i == j) {
                        dp[j] = nums[j];
                    } else if (i < j) {
                        dp[j] = dp[j] - nums[i - 1];
                    }
                }
                if (i <= j && dp[j] >= target) {
                    int len = j - i + 1;
                    if (min == 0) {
                        min = len;
                    } else if (min > len) {
                        min = len;
                    }
                }
            }
        }
        return min;
    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i][0] = nums[0];
                for (int j = 1; j < nums.length; j++) {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
            } else {
                for (int j = 0; j < nums.length; j++) {
                    if (i == j) {
                        dp[i][j] = nums[i];
                    } else if (i < j) {
                        dp[i][j] = dp[i - 1][j] - nums[i - 1];
                    }
                }
            }
        }
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (dp[i][j] >= target) {
                    int len = j - i + 1;
                    if (min == 0) {
                        min = len;
                    } else if (min > len) {
                        min = len;
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(Solution209.minSubArrayLen(7, nums));
    }
}
