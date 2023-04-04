package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-04-05 00:31:35
 * @Email g863821569@gmail.com
 */
public class Solution55 {

    @Test
    public void testSolution() {
        int[] nums = new int[]{0};
        System.out.println(canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i <= max; i++) {
            int next = i + nums[i];
            if (next > max) max = next;
            if (max >= nums.length - 1) return true;
        }
        return false;
    }
}
