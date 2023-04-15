package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class Solution343 {

    @Test
    public void testSolution() {
        int n = 20;
        System.out.println(integerBreak(n));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i / 2 + 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static int integerBreak1(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] ab = maxAb(n);
        return ab[0] * ab[1];
    }

    private static int[] maxAb(int n) {
        int max = 0;
        if (n <= 4)
            return new int[]{n, 1};
        int c = 1, d = n;
        for (int i = n / 2 - 1; i < n / 2 + 1; i++) {
            int a = i;
            int b = n - i;
            int[] aAb = maxAb(a);
            a = aAb[0] * aAb[1];
            int[] bAb = maxAb(b);
            b = bAb[0] * bAb[1];
            if (a * b > max) {
                c = a;
                d = b;
                max = a * b;
            }
        }
        return new int[]{c, d};
    }

    public static void main(String[] args) {
        System.out.println(integerBreak1(9));
    }
}
