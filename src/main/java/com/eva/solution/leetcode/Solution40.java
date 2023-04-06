package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2023-04-06 23:06:18
 * @Email g863821569@gmail.com
 */
public class Solution40 {

    @Test
    public void testSolution() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum2(candidates, target));
    }

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<>();
        combinationSum2(candidates, target, item, 0, 0);
        return ans;
    }

    public void combinationSum2(int[] candidates, int target, List<Integer> item, int count, int pos) {
        if (count == target) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i - 1]) continue;
            item.add(candidates[i]);
            count += candidates[i];
            if (count > target) {
                item.remove(item.size() - 1);
                break;
            }
            combinationSum2(candidates, target, item, count, i + 1);
            item.remove(item.size() - 1);
            count -= candidates[i];
        }
    }
}
