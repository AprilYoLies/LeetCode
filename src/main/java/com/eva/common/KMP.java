package com.eva.common;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-09-13
 * @Email g863821569@gmail.com
 */

/**
 * BBC ABCDAB ABCDABCDABDE BC ABCDAB ABCDABCDABDE DABCDABDE BC ABCDAB ABCD
 * ABCDABD
 */
public class KMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        int[] table = calMatchTable(pattern);
        List<Integer> poses = findPatternPos(text, pattern, table);
        StringBuilder sb = new StringBuilder();
        for (int pos : poses) {
            sb.append(pos).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static List<Integer> findPatternPos(String text, String pattern, int[] table) {
        List<Integer> poses = new ArrayList<>();
        int pos = 0, cur = 0, tLen = text.length(), pLen = pattern.length(), limit = tLen - pLen;
        while (pos <= limit) {
            while (cur < pLen && text.charAt(pos + cur) == pattern.charAt(cur)) cur++;
            if (cur == pLen) {
                poses.add(pos);
                pos++;
                cur = 0;
            } else if (cur == 0) pos++;
            else {
                int diff = cur - table[cur - 1];
                pos += diff;
                cur = 0;
            }
        }
        return poses;
    }

    private static int[] calMatchTable(String pattern) {
        int len = pattern.length();
        int[] table = new int[len];
        for (int i = 1; i < len; i++) {
            Set<String> set = new HashSet<>();
            int max = 0;
            for (int j = 1; j <= i; j++) {
                set.add(pattern.substring(0, j));
            }
            for (int j = 1; j <= i; j++) {
                String suffix = pattern.substring(j, i + 1);
                int l = suffix.length();
                if (set.contains(suffix) && l > max) max = l;
            }
            table[i] = max;
        }
        return table;
    }
}
