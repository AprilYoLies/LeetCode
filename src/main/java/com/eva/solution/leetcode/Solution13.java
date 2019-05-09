package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution13 {
    public int romanToInt(String s) {
        s = s.replace("CM", "900#");
        s = s.replace("CD", "400#");
        s = s.replace("XC", "90#");
        s = s.replace("XL", "40#");
        s = s.replace("IX", "9#");
        s = s.replace("IV", "4#");
        s = s.replace("M", "1000#");
        s = s.replace("D", "500#");
        s = s.replace("C", "100#");
        s = s.replace("L", "50#");
        s = s.replace("X", "10#");
        s = s.replace("V", "5#");
        s = s.replace("I", "1#");
        String[] strs = s.split("#");
        int res = 0;
        int i = 0;
        while (i < strs.length) {
            res += Integer.parseInt(strs[i]);
            i++;
        }
        return res;
    }
}
