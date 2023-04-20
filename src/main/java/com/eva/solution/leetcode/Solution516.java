package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-03-29 21:55:22
 * @Email g863821569@gmail.com
 */
public class Solution516 {

    @Test
    public void testSolution() {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int max = Integer.MIN_VALUE;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    boolean iEqJ = s.charAt(i) == s.charAt(j);
                    if (j - i >= 2) {
                        if (iEqJ) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        } else {
                            dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                        }
                    } else {
                        dp[i][j] = iEqJ ? 2 : 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
