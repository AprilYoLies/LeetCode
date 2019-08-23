package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) return results;
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>(nums.length);
        findResult(nums, results, tmp, visited);
        return results;
    }

    private static void findResult(int[] nums, List<List<Integer>> results, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            List<Integer> result = new ArrayList<>(tmp);
            results.add(result);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            findResult(nums, results, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{}));
    }
}
