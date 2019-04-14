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
        int l = words[0].length() * words.length;
        int wl = words[0].length();
        int sl = s.length();
        int wc = words.length;
        ArrayList<String> toVisit = new ArrayList<>(Arrays.asList(words));
        LinkedList<String> visited = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // 如果剩余的字符串小于串联字符串的总和，那就退出循环
        for (int i = 0; i < sl - l + 1; i++) {
            sb.append(s.substring(i));
            for (int k = 0; k < wc; k++) {
                int before = visited.size();
                String subs = sb.substring(0, wl);
                for (int j = 0; j < toVisit.size(); j++) {
                    if (subs.equals(toVisit.get(j))) {
                        visited.add(toVisit.remove(j));
                        sb.delete(0, wl);
                        break;
                    }
                }
                int after = visited.size();
                if (before == after) break;
                if (after == wc) ans.add(i);
            }
            toVisit.addAll(visited);
            visited.clear();
            sb.delete(0, sb.length());
        }
        return ans;
    }
}
