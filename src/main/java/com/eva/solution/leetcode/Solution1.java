package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-04-14
 * @Email g863821569@gmail.com
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }
}
