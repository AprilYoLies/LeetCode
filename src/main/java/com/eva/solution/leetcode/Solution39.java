package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2023-04-04 19:04:18
 * @Email g863821569@gmail.com
 */
public class Solution39 {

    @Test
    public void testSolution() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<>();
        combinationSum(candidates, target, item, 0, 0);
        return ans;
    }


    public void combinationSum(int[] candidates, int target, List<Integer> item, int count, int pos) {
        if (count == target) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            item.add(candidates[i]);
            count += candidates[i];
            if (count > target) {
                item.remove(item.size() - 1);
                break;
            }
            combinationSum(candidates, target, item, count, pos);
            item.remove(item.size() - 1);
            count -= candidates[i];
            pos++;
        }
    }
}
