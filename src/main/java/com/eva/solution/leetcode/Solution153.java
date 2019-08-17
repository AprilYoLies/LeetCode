package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-17
 * @Email g863821569@gmail.com
 */
public class Solution153 {
    public static int findMin(int[] nums) {
        if (!(nums[0] > nums[nums.length - 1]))
            return nums[0];
        int target = nums[0], l = 1, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (isLessThan(nums[mid], target)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        for (int i = r; i <= l + 1; i++) {
            if (isLessThan(nums[i], target))
                return nums[i];
        }
        // Can't run to there
        return nums[r];
    }

    public static boolean isLessThan(int cur, int target) {
        return cur < target;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 2}));
    }
}
