package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class Solution279 {
    public static int numSquares(int n) {
        int[] nums = new int[n + 3];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        for (int i = 4; i <= n; i++) {
            int s = (int) Math.sqrt(i);
            if (i - s * s == 0)
                nums[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 2; j <= s; j++) {
                    int maybeMin = nums[i - j * j] + 1;
                    if (maybeMin < min) {
                        min = maybeMin;
                    }
                }
                nums[i] = min;
            }
        }
        return nums[n];
    }

    public int numSquaresSlow(int n) {
        int[] nums = new int[n + 3];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        for (int i = 4; i <= n; i++) {
            int s = (int) Math.sqrt(i);
            if (i - s * s == 0)
                nums[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j < i / 2 + 1; j++) {
                    int maybeMin = nums[j] + nums[i - j];
                    if (maybeMin < min)
                        min = maybeMin;
                }
                nums[i] = min;
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
