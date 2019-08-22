package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        findResults(results, 0, 0, new StringBuilder(), s);
        return results;
    }

    private static void findResults(List<String> results, int cur, int c, StringBuilder pre, String s) {
        if (c == 4 || cur >= s.length()) {
            if (cur == s.length() && c == 4)
                results.add(pre.toString());
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (i > 0 && s.charAt(cur) == '0') return;
            int to = cur + i + 1;
            if (to > s.length()) return;
            String seg = s.substring(cur, to);
            if (Integer.parseInt(seg) > 255) continue;
            if (pre.length() != 0)
                pre.append(".");
            pre.append(seg);
            findResults(results, to, c + 1, pre, s);
            pre.delete(pre.length() - (i + 1), pre.length());
            if (pre.length() > 0 && pre.charAt(pre.length() - 1) == '.') pre.deleteCharAt(pre.length() - 1);
        }
    }

    public static void main(String[] args) {
        restoreIpAddresses("010010");
    }
}
