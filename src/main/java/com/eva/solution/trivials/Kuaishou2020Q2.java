package com.eva.solution.trivials;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Kuaishou2020Q2 {
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
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> combinations = letterCombinations1(line);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String combination : combinations) {
            sb.append(combination).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1).append("]");
        System.out.println(sb.toString());
    }
}
