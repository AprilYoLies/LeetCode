package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-17
 * @Email g863821569@gmail.com
 */
public class Solution69 {
    public static int mySqrt(int x) {
        if (x <= 1)
            return x;
        long l = 1, r = x;
        while (l < r) {
            long mid = (l + r) >>> 1;
            long pow = mid * mid;
            if (pow == x)
                return (int) mid;
            else if (pow < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        long pow = l * l;
        if (l == r) {
            if (pow > x)
                return (int) (l - 1);
            return (int) l;
        }
        return (int) (pow < x ? l : r);
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " - " + mySqrt(i));
        }
    }
}
