package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class Solution303 {
    private int[] sums;

    public Solution303(int[] nums) {
        sums = new int[nums.length];
        if (nums.length == 0)
            return;
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (j >= sums.length)
            j = sums.length - 1;
        if (i <= 0)
            return sums[j];
        return sums[j] - sums[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        Solution303 solution303 = new Solution303(nums);
        System.out.println(solution303.sumRange(0,2));
        System.out.println(solution303.sumRange(2,5));
        System.out.println(solution303.sumRange(0,5));
    }
}
