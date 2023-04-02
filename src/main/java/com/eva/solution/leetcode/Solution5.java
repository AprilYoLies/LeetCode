package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2019-04-12
 * @Email g863821569@gmail.com
 */
public class Solution5 {
    private static int[] res = new int[2];

    @Test
    public void testLongestPalindrome() {
        String s = "cbbd";
        System.out.println(longestPalindrome2(s));
    }

    public String longestPalindrome(String s) {
        int longest = 0;
        String ans = "";
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - 1 >= i + 1) {
                        if (dp[i + 1][j - 1] != 0) dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = j - i + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > longest) {
                    longest = dp[i][j];
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public String longestPalindrome2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        int l = 0;
        int r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    boolean iEqJ = s.charAt(i) == s.charAt(j);
                    if (j == i + 1) {
                        dp[i][j] = iEqJ;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] && iEqJ;
                    }
                }
                int len = j - i + 1;
                if (dp[i][j] && max < len) {
                    max = len;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public String longestPalindrome1(String s) {
        if ("".equals(s) || s.length() == 1) return s;
        int[] range = new int[]{1, 0};
        for (int i = 0; i < s.length() - 1; i++) {
            int[] t = match(i, s);
            if (t[1] - t[0] > range[1] - range[0]) {
                range[0] = t[0];
                range[1] = t[1];
            }
        }
        return s.substring(range[0], range[1] + 1);
    }

    /**
     * 三指针中心拓展（考虑回文为奇或偶的情况）
     *
     * @param pos 中心点
     * @param s   原字符串
     * @return 该中心点情况下，最长回文串的左右端点下标
     */
    private int[] match(int pos, String s) {
        int i = pos, j = pos + 1, k = pos;
        boolean isOdd = true, isEven = true;
        while (i >= 0 && j <= s.length() - 1 && k <= s.length() - 1) {
            if (s.charAt(i) == s.charAt(j) && isEven) j++;
            else isEven = false;
            if (s.charAt(i) == s.charAt(k) && isOdd) k++;
            else isOdd = false;
            if (isEven || isOdd) i--;
            else break;
        }
        int bigger = j > k ? j : k;
        res[0] = i + 1;
        if (j == s.length()) if (i >= 0 && k < s.length() && s.charAt(i) == s.charAt(k)) res[0]--;
        res[1] = bigger - 1;
        return res;
    }
}
