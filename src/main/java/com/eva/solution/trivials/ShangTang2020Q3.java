package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-21
 * @Email g863821569@gmail.com
 */
public class ShangTang2020Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long x = sc.nextLong();
        long l = 1, r = n;
        while (l < r) {
            long mid = (l + r) >>> 1;
            long val = convert(n, mid);
            if (val == x) {
                System.out.println(mid);
                return;
            } else if (val > x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        for (long i = r - 1; i <= l + 1; i++) {
            if (i < 1) continue;
            long val = convert(n, i);
            if (val < x) {
                System.out.println(i - 1);
                return;
            } else if (val == x) {
                System.out.println(i);
                return;
            }
        }
    }

    private static long convert(long num, long radix) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % radix);
            num /= radix;
        }
        return Long.parseLong(sb.reverse().toString());
    }
}
