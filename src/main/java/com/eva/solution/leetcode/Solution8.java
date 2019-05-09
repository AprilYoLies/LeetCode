package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution8 {
    public int myAtoi(String str) {
        if ("".equals(str))
            return 0;
        int to = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (((c == '+' || c == '-') && i < str.length() - 1 &&
                    (str.charAt(i + 1) <= '9' && str.charAt(i + 1) >= '0'))
                    || (c <= '9' && c >= '0')) {
                to = i;
                break;
            } else if (c != ' ')
                break;
        }
        // 以±或者数字开头的字符串
        if (to < 0)
            return 0;
        String s1 = str.substring(to);
        char head = s1.charAt(0);
        String s2 = s1;
        if (head == '+' || head == '-') {
            s2 = s1.substring(1);
        }
        to = -1;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (c != '0') {
                to = i;
                break;
            }
        }
        if (to >= 0)
            s2 = s2.substring(to);
        else return 0;
        to = -1;
        char[] chars = s2.toCharArray();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            to = i;
            if (!(c >= '0' && c <= '9')) {
                to -= 1;
                break;
            }
        }
        long ans = 0;
        if (to < 0)
            return 0;
        boolean overflow = false;
        for (int i = 0; i <= to; i++) {
            ans += Math.pow(10, to - i) * (chars[i] - 48);
        }
        if (head == '-') {
            if (ans - 1 > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) (-1 * ans);
        }
        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ans;
    }
}
