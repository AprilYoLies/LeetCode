package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution11 {

    @Test
    public void maxArea() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int s = Math.min(height[i], height[j]) * (j - i);
            if (s > max) {
                max = s;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
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
