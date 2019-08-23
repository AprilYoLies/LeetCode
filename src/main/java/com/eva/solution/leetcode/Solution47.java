package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (visited[i] || (i - 1 >= 0 && nums[i - 1] == nums[i] && !visited[i - 1])) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            findResult(nums, results, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 3}));
    }
}
