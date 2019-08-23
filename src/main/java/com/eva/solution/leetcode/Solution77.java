package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public static List<List<Integer>> combine(int n, int k) {
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
        System.out.println(combine(4, 3));
        System.out.println();
        System.out.println(combine1(4, 3));
    }
}
