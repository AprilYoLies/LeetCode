package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2019-04-23
 * @Email g863821569@gmail.com
 */
public class Solution32 {

    @Test
    public void testSolution() {
        String str = "(()())())())())())()())";
        System.out.println(longestValidParentheses(str));
    }

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            char aChar = s.charAt(i);
            if (aChar == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int longestValidParentheses1(String s) {
        int a = getLenght(s, '(');
        int b = getLenght(new StringBuilder(s).reverse().toString(), ')');
        return Math.max(a, b);
    }

    private int getLenght(String s, char ch) {
        int max = 0;
        int count = 0;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch == s.charAt(i)) c++;
            else {
                // 这种情况下，可以确定之前的字符串已经不可能和后边的字符串构成合法括号匹配的子串了，清除记录信息
                if (--c < 0) {
                    count = 0;
                    c = 0;
                } else {
                    // 匹配一个括号，则长度加2
                    count += 2;
                    // 如果是完全匹配，则记录长度
                    if (c == 0) if (count > max) max = count;

                }
            }
        }
        return max;
    }
}
