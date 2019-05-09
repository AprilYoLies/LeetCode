package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("()");
        for (int i = 0; i < n - 1; i++) {
            conbine(set);
        }
        return new ArrayList<>(set);
    }

    private void conbine(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(set.size());
        list.addAll(set);
        set.clear();
        for (String pre : list) {
            int length = pre.length();
            for (int i = 0; i <= length; i++) {
                String head = pre.substring(0, i);
                String tail = pre.substring(i, length);
                sb.append(head).append("()").append(tail);
                set.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
    }
}
