package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-12
 * @Email g863821569@gmail.com
 */
public class Solution213 {
    // sum[n] = num[n] + sum[n - 2]
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if (nums.length == 3)
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int a = shift(nums, 0);
        int b = shift(nums, 1);
        return Math.max(a, b);
    }

    private static int shift(int[] nums, int offset) {
        int[] money = new int[nums.length];
        money[offset] = nums[offset];
        money[1 + offset] = Math.max(nums[offset], nums[1 + offset]);
        money[2 + offset] = Math.max(money[offset] + nums[2 + offset], nums[1 + offset]);
        for (int i = 2 + offset + 1; i < nums.length; i++) {
            money[i] = Math.max((nums[i] + money[i - 2]), money[i - 1]);
        }
        int i = offset == 0 ? nums.length - 2 : nums.length - 1;
        return money[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 2};
        System.out.println(rob(nums));
    }
}
