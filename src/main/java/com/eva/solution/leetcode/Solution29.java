package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == divisor) return 1;
        if (divisor == 1) return dividend;
        boolean hasMin = false;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            hasMin = true;
            dividend = -Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) return 0;

        boolean positive = true;
        if ((dividend > 0 && divisor < 0) || dividend < 0 && divisor > 0) positive = false;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int res = 0;
        int[] n = getAns(a, b);
        while (n[0] >= 1) {
            res += n[0];
            a = a - n[1];
            n = getAns(a, b);
        }
        if (hasMin && a + 1 == b)
            res++;
        if (positive)
            return res;
        else return -res;
    }

    public int[] getAns(int divident, int divisor) {
        int pre = 0;
        int count = 0;
        if (divisor > divident) return new int[]{0, pre};
        for (; ; ) {
            pre = divisor;
            divisor = divisor << 1;
            if (pre > divisor || divisor > divident) break;
            count++;
        }
        return new int[]{(int) Math.pow(2, count), pre};
    }
}
