package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-12
 * @Email g863821569@gmail.com
 */

/**
 * 4
 * 0 -2 -7 0 9 2 -6 2 -4 1 -4 1 -1 8 0 -2
 */
public class Qunar2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxSubArray(arr, n));
    }

    public static int maxSubArray(int[][] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] sum = new int[n];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sum[k] += arr[j][k];
                }
                max = Math.max(maxSubArray(sum, n), max);
            }
        }
        return max;
    }

    public static int maxSubArray(int[] array, int n) {
        int[] dp = new int[n];
        dp[0] = array[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        }
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
