package com.eva.solution.leetcode;

public class Solution392 {
    public static boolean isSubsequence(String s, String t) {
        int idx = 0;
        next:
        for (int i = 0; i < s.length(); i++) {
            for (int j = idx; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    idx = ++j;
                    continue next;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("1", "1"));
    }
}
