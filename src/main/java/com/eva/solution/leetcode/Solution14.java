package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null || "".equals(strs[i])) {
                return "";
            }
        }
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i == strs[0].length())
                return strs[0];
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }
}
