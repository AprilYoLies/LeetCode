package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-10
 * @Email g863821569@gmail.com
 */

/**
 * 10 2
 */
public class Baidu2020Q2 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        calPark(n, k);
        System.out.println(count);
    }

    private static void calPark(int n, int k) {
        if (n - k <= 0 || (n - k) % 2 == 1) {
            count++;
            return;
        }
        calPark((n - k) / 2, k);
        calPark((n - k) / 2 + k, k);
    }
}
