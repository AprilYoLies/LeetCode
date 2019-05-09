package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int j = 1; j < height.length; j++) {
            for (int i = 0; i < j; i++) {
                int vol = Math.min(height[i], height[j]) * (j - i);
                if (max < vol) {
                    max = vol;
                }
            }
        }
        return max;
    }
}
