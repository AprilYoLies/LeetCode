package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-03-21 22:30:11
 * @Email g863821569@gmail.com
 */
public class Solution42 {

    @Test
    public void testFourSum() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMax[i] = 0;
            } else {
                leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightMax[i] = 0;
            } else {
                rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
            }
        }
        for (int i = 1; i < height.length - 1; i++) {
            int vol = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (vol > 0) {
                sum += vol;
            }
        }
        return sum;
    }
}
