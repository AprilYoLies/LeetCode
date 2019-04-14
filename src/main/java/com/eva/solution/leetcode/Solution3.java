package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-04-14
 * @Email g863821569@gmail.com
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (i < chars.length && j < chars.length) {
            if (set.add(chars[j])) {
                j++;
                if (max < j - i)
                    max = j - i;
            } else {
                set.remove(chars[i]);
                i++;
            }
        }
        return max;
    }
}