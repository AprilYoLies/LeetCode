package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {

    @Test
    public void testSolution() {
        System.out.println(combine(5, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        combine(n, k, 1, ans, item);
        return ans;
    }

    public void combine(int n, int k, int pos, List<List<Integer>> ans, List<Integer> item) {
        for (int i = pos; i <= n; i++) {
            item.add(i);
            if (item.size() == k) {
                ans.add(new ArrayList<>(item));
            } else {
                combine(n, k, i + 1, ans, item);
            }
            item.remove(item.size() - 1);
        }
    }

    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        findResults(results, 1, tmp, n, k);
        return results;
    }

    private static void findResults(List<List<Integer>> results, int from, List<Integer> tmp, int n, int k) {
        if (k == 0) {
            results.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = from; i <= n - k + 1; i++) {
            tmp.add(i);
            findResults(results, i + 1, tmp, n, k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(combineList, combinations, 1, k, n);
        return combinations;
    }

    private static void backtracking(List<Integer> combineList, List<List<Integer>> combinations, int start, int k, final int n) {
        if (k == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {  // 剪枝
            combineList.add(i);
            backtracking(combineList, combinations, i + 1, k - 1, n);
            combineList.remove(combineList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine2(4, 3));
        System.out.println();
        System.out.println(combine1(4, 3));
    }
}
