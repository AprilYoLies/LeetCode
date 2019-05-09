package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        try {
            if ("".equals(needle)) return 0;
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
                }
            }
            return -1;
        } catch (Throwable t) {
            return -1;
        }
    }
}
