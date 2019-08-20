package com.eva.solution.leetcode;

import java.util.Arrays;

public class Solution455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = 0;
        for (int i : g) {
            if (s.length == 0 || i > s[s.length - 1])
                break;
            for (int j = index; j < s.length; j++) {
                if (s[j] >= i) {
                    count++;
                    index = ++j;
                    break;
                }
            }
        }
        return count;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{10, 9, 8, 7}, new int[]{10, 9, 8, 7}));
    }
}
