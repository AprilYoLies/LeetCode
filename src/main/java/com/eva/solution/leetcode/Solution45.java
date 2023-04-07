package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-04-06 23:06:18
 * @Email g863821569@gmail.com
 */
public class Solution45 {

    @Test
    public void testSolution() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int step = 0;
        int max = 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            step++;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) return step;
                int canGo = nums[i + j] + i + j;
                if (canGo > max) {
                    max = canGo;
                    pos = i + j;
                }
            }
            i = pos - 1;
        }
        return -1;
    }
}
