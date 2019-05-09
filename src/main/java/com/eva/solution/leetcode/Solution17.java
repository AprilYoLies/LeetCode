package com.eva.solution.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution17 {
    private static final String[][] table = {
            {"a", "b", "c", ""},
            {"a", "b", "c", ""},
            {"a", "b", "c", ""},
            {"d", "e", "f", ""},
            {"g", "h", "i", ""},
            {"j", "k", "l", ""},
            {"m", "n", "o", ""},
            {"p", "q", "r", "s"},
            {"t", "u", "v", ""},
            {"w", "x", "y", "z"},
    };

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if ("".equals(digits)) return list;
        int deepth = digits.length();
        char c = digits.charAt(digits.length() - deepth);
        int cnum = c - 48;
        append(list, deepth, cnum, "", digits);
        return list;
    }

    private void append(List<String> list, int deepth, int num, String pre, String digits) {
        char c = digits.charAt(digits.length() - deepth);
        int cnum = c - 48;
        if (deepth == 1) {
            for (int i = 0; i < table[cnum].length; i++) {
                if (!"".equals(table[cnum][i])) {
                    list.add(pre + table[cnum][i]);
                }
            }
        } else {
            deepth--;
            for (int i = 0; i < table[cnum].length; i++) {
                if (!"".equals(table[cnum][i])) {
                    append(list, deepth, cnum, pre + table[cnum][i], digits);
                }
            }
        }
    }
}
