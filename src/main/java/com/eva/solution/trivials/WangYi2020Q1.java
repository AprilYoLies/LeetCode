package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-20
 * @Email g863821569@gmail.com
 */
public class WangYi2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long min = Math.min(a, b), max = Math.max(a, b);
        long up = min;
        long maxGY = 0, minGB = max;
        for (int i = 1; i <= up; i++) {
            if (min % i == 0) {
                long t = min / i;
                if (max % t == 0) {
                    maxGY = t;
                    break;
                }
            }
            up = min / i + i;
        }
        for (int i = 1; i <= min; i++) {
            if (max * i % min == 0) {
                minGB = max * i;
                break;
            }
        }
        System.out.println(maxGY + " " + minGB);
    }
}
