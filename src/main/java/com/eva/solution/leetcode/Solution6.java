package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int t = numRows + numRows - 2;
        for (int i = 0; i < chars.length; ) {
            sb.append(chars[i]);
            i += t;
        }
        if (numRows > 2) {
            for (int i = 1; i < numRows - 1; i++) {
                int m = i;
                for (int j = i; j < chars.length; ) {
                    sb.append(chars[j]);
                    j = j + t - 2 * m;
                    if (j < chars.length) {
                        sb.append(chars[j]);
                    }
                    j += 2 * m;
                }
            }
        }
        for (int i = numRows - 1; i < chars.length; ) {
            sb.append(chars[i]);
            i += t;
        }
        return sb.toString();
    }
}
