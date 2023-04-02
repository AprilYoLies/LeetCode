package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution17 {
    @Test
    public void testLetterCombinations() {
        String digits = "2345";
        System.out.println(letterCombinations(digits));
    }

    private static final String[][] table = {
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
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        letterCombinations(digits, 0, ans, sb);
        return ans;
    }

    public void letterCombinations(String digits, int pos, List<String> ans, StringBuilder sb) {
        if (pos >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String[] chars = table[Integer.parseInt(digits.substring(pos, pos + 1)) - 2];
        for (String aChar : chars) {
            if ("".equals(aChar)) continue;
            sb.append(aChar);
            letterCombinations(digits, pos + 1, ans, sb);
            sb.deleteCharAt(pos);
        }
    }

    public List<String> letterCombinations2(String digits) {
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

    public static List<String> letterCombinations1(String digits) {
        List<String> results = new ArrayList<>();
        if ("".equals(digits)) return results;
        findResults(results, 0, digits, new StringBuilder());
        return results;
    }

    private static void findResults(List<String> results, int i, String digits, StringBuilder pre) {
        if (i == digits.length()) {
            results.add(pre.toString());
            return;
        }
        int idx = digits.charAt(i) - '0' - 2;
        String[] strs = table[idx];
        for (String str : strs) {
            if ("".equals(str)) continue;
            pre.append(str);
            findResults(results, i + 1, digits, pre);
            pre.deleteCharAt(pre.length() - 1);
        }
    }

    public static void main(String[] args) {
        letterCombinations1("");
    }
}
