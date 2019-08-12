package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-12
 * @Email g863821569@gmail.com
 */
public class Solution214 {
    // "aacecaaa"
    public static String shortestPalindrome(String s) {
        if (s == null || s.equals(""))
            return s;
        int len = 1;
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            int step = 1;
            while (i - step >= 0 && i + step < s.length()) {
                if (s.charAt(i - step) == s.charAt(i + step)) {
                    if (i - step == 0) {
                        len = 2 * step + 1;
                        break;
                    }
                    step++;
                } else {
                    break;
                }
            }

            step = 0;
            while (i - step >= 0 && i + 1 + step < s.length()) {
                if (s.charAt(i - step) == s.charAt(i + 1 + step)) {
                    if (i - step == 0)
                        if (2 * step + 2 > len)
                            len = 2 * step + 2;
                    step++;
                } else
                    break;
            }
        }
        return new StringBuilder(s.substring(len)).reverse().append(s).toString();
    }

    public static void main(String[] args) {
        String str = "abc";
        String s = shortestPalindrome(str);
        System.out.println(s);
    }
}
