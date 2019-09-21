package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-21
 * @Email g863821569@gmail.com
 */
public class WangYiGame2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : arr) {
            System.out.println(calMin(x));
        }
    }

    private static String calMin(int x) {
        StringBuilder sb = new StringBuilder();
        char c = (char) (x % 9 + '0');
        if (c != '0')
            sb.append(c);
        int n = x / 9;
        while (n-- > 0) sb.append('9');
        return sb.toString();
    }
}
