package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-21
 * @Email g863821569@gmail.com
 */
public class ShangTang2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean flag = false;
        int begin = -1;
        for (int i = 0; i < n; i++) {
            if (!flag && arr[i] < 0) {
                flag = true;
            }
            if (flag && arr[i] >= 0) {
                begin = i;
                break;
            }
        }
        if (begin == -1) begin = 0;
        int max = 0, sum = 0;
        for (int i = begin; i < n; i++) {
            if (sum > 0)
                sum += arr[i];
            else sum = arr[i];
            if (sum > max) max = sum;
        }
        for (int i = 0; i < begin; i++) {
            if (sum > 0)
                sum += arr[i];
            else sum = arr[i];
            if (sum > max) max = sum;
        }
        System.out.println(max);
    }
}
