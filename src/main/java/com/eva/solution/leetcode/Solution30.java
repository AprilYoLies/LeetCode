package com.eva.solution.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-04-14
 * @Email g863821569@gmail.com
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        if (words == null || words.length == 0 || "".equals(s)) return ans;
        int len = words[0].length() * words.length;
        int wl = words[0].length();
        int sl = s.length();
        int wc = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        int[][] usedTable = new int[2][wc];
        for (String s1 : words) {
            Integer i = map.get(s1);
            if (i == null) map.put(s1, index++);
            usedTable[0][map.get(s1)]++;
        }
        // 如果剩余的字符串小于串联字符串的总和，那就退出循环
        for (int i = 0; i < sl - len + 1; i++) {
            int l = i;
            for (int k = 0; k < wc; k++) {
                String subs = s.substring(l, l + wl);
                Integer cur = map.get(subs);
                if (cur != null && usedTable[0][cur] != usedTable[1][cur]++) l += wl;
                else break;
                if (l - i == len) ans.add(i);
            }
            Arrays.fill(usedTable[1], 0);
        }
        return ans;
    }
}
