package com.eva.solution.leetcode;

import org.junit.Test;

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

    @Test
    public void testSolution() {
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        generateParenthesis(n * 2, sb, ans);
        return ans;
    }

    public void generateParenthesis(int len, StringBuilder sb, List<String> ans) {
        if (sb.length() == len) {
            String str = sb.toString();
            if (validate(str)) {
                ans.add(str);
            }
            return;
        }
        sb.append("(");
        generateParenthesis(len, sb, ans);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        generateParenthesis(len, sb, ans);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean validate(String str) {
        char[] chars = str.toCharArray();
        int flag = 0;
        for (char aChar : chars) {
            if ('(' == aChar) {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) return false;
        }
        return flag == 0;
    }

    public List<String> generateParenthesis2(int n) {
        Set<String> set = new HashSet<>();
        set.add("()");
        for (int i = 0; i < n - 1; i++) {
            addParenthesis(set);
        }
        return new ArrayList<>(set);
    }

    private void addParenthesis(Set<String> set) {
        List<String> tmp = new ArrayList<>(set);
        set.clear();
        for (String cur : tmp) {
            StringBuilder sb = new StringBuilder(cur);
            for (int i = 0; i <= sb.length(); i++) {
                sb.insert(i, "()");
                set.add(sb.toString());
                sb.delete(i, i + 2);
            }
        }
    }

    public List<String> generateParenthesis1(int n) {
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
