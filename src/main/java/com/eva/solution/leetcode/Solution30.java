package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<String> toVisit = new ArrayList<>(Arrays.asList(words));
        LinkedList<String> visited = new LinkedList<>();
        // 如果剩余的字符串小于串联字符串的总和，那就退出循环
        for (int i = 0; i < sl - len + 1; i++) {
            int l = i;
            for (int k = 0; k < wc; k++) {
                int before = visited.size();
                String subs = s.substring(l, l + wl);
                for (int j = 0; j < toVisit.size(); j++) {
                    if (subs.equals(toVisit.get(j))) {
                        visited.add(toVisit.remove(j));
                        l += wl;
                        break;
                    }
                }
                int after = visited.size();
                if (before == after) break;
                if (after == wc) ans.add(i);
            }
            toVisit.addAll(visited);
            visited.clear();
        }
        return ans;
    }
}