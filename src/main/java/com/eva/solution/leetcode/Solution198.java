package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-12
 * @Email g863821569@gmail.com
 */
public class Solution198 {
    // sum[n] = num[n] + sum[n - 2]
    public static int rob(int[] nums) {
        int[] money = new int[nums.length];
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            money[i] = Math.max((nums[i] + money[i - 2]), money[i - 1]);
        }
        return money[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 2};
        rob(nums);
    }
}
