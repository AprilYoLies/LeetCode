package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-04-15 15:05:34
 * @Email g863821569@gmail.com
 */
public class Solution84 {

    @Test
    public void testSolution() {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int[] leftMin = new int[heights.length];
        int[] rightMin = new int[heights.length];
        leftMin[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) {
                t = leftMin[t];
            }
            leftMin[i] = t;
        }
        rightMin[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < heights.length && t != -1 && heights[t] >= heights[i]) {
                t = rightMin[t];
            }
            rightMin[i] = t;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (rightMin[i] - leftMin[i] - 1);
            max = Math.max(max, area);
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            if (i > 0 && heights[i] == heights[i - 1]) continue;
            int l = i;
            int r = i;
            while (l >= 0 && heights[l] >= heights[i]) {
                l--;
            }
            while (r < heights.length && heights[r] >= heights[i]) {
                r++;
            }
            int area = heights[i] * (r - l - 1);
            max = Math.max(max, area);
        }
        return max;
    }
}
