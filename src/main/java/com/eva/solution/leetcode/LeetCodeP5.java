package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-04-12
 * @Email g863821569@gmail.com
 */
public class LeetCodeP5 {
    private static int[] res = new int[2];

    public String longestPalindrome(String s) {
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
     * @param pos 中心点
     * @param s 原字符串
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
        if (j == s.length())
            if (i >= 0 && k < s.length() && s.charAt(i) == s.charAt(k)) res[0]--;
        res[1] = bigger - 1;
        return res;
    }
}
