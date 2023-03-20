package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author EvaJohnson
 * @Date 2023-03-20 21:50:18
 * @Email g863821569@gmail.com
 */
public class Solution545 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }

    @Test
    public void main() {
        int[] nums1 = new int[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 8};
        int[] nums2 = new int[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 8};
        int[] nums3 = new int[]{1, 2, -2, -2, 3, 4, 5, 6, -7, -8};
        int[] nums4 = new int[]{1, 2, -2, -2, 3, 4, 5, 6, -7, -8};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
