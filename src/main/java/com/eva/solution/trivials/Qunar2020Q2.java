package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-12
 * @Email g863821569@gmail.com
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
        int[] temp = new int[n];
        for (int i = 0; i < n; i++)
            temp[i] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            temp = arr[i];
            max = Math.max(maxSubArray(temp, n), max);
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[k] += arr[j][k];
                }
                max = Math.max(maxSubArray(temp, n), max);
            }
        }
        return max;
    }

    public static int maxSubArray(int[] array, int n) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
