package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */
public class Iqiy2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        double p = 1.0;
        p = p * calP(m, n);
        System.out.format("%1.5f", Math.round(p * 100000) / 100000.0);
    }

    private static double calP(double m, double n) {
        if (m == 0) return 0;
        if (n <= 0) return 1;
        double win = m / (m + n);
        if (n > 1) {
            double al = n / (m + n);
            double bl = (n - 1) / (n + m - 1);
            double cl = (n - 2) / (m + n - 2);
            double ch = (m) / (m + n - 2);
            return win + al * bl * cl * calP(m, n - 3) + al * bl * ch * calP(m - 1, n - 2);
        }
        return win;
    }
}
