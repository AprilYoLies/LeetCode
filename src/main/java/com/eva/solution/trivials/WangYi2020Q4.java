package com.eva.solution.trivials;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-09-20
 * @Email g863821569@gmail.com
 */

/**
 * 5 10
 * mklghiegbt
 * jtegkltjzf
 * qhmkljkmhq
 * fzjtebgetj
 * moqhmlglkm
 * <p>
 * 1 2
 * ab
 */
public class WangYi2020Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] rc = sc.nextLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            strs.add(sc.nextLine());
        }
        int min = Math.min(r, c);
        for (int k = 0; k < strs.size(); k++) { // 每个字符串
            for (int i = min - 1; i >= 1; i--) {    // 不同长度
                if (r - k < i) continue;
                for (int j = 0; j < c; j++) {   // 获取起始点
                    if (j + i > c) break;
                    String str = strs.get(k).substring(j, j + i);
                    int len = str.length();
                    int[] table = calMatchTable(str);
                    for (int l = k + 1; l < r; l++) {   // 查看后边的行是否有匹配字符串的
                        if (r - l < len) break;
                        String text = strs.get(l);
                        List<Integer> pos = findPatternPos(text, str, table);   // 匹配的位置
                        if (pos.size() == 0) continue;
                        next:
                        for (Integer po : pos) {
                            for (int m = 1; m < len; m++) {
                                if (!strs.get(k + m).substring(j, j + i).equals(strs.get(l + m).substring(po, po + i)))
                                    continue next;
                            }
                            System.out.println(str.length());
                            System.out.println((k + 1) + " " + (j + 1));
                            System.out.println((l + 1) + " " + (po + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
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
