package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution459 {

    @Test
    public void testReverseWords() {
        String str = "a";
        System.out.println(repeatedSubstringPattern(str));
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i < len / 2 + 1; i++) {
            if (len % i == 0) {
                int n = len / i;
                boolean flag = true;
                String s1 = s.substring(0, i);
                for (int j = 1; j < n; j++) {
                    String s2 = s.substring(j * i, j * i + i);
                    if (!s1.equals(s2)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
