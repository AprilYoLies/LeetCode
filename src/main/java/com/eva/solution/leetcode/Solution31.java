package com.eva.solution.leetcode;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-04-23
 * @Email g863821569@gmail.com
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len - 2;
        int max = nums[len - 1];
        for (int i = 0; i < len - 1; i++) {
            // 这种情况下，可以肯定后边的序列是有满足条件的元素，则进行交换
            if (nums[index - i] < max) {
                int r = 0;
                int min = Integer.MAX_VALUE;
                // 查到后边序列中大于当前值且尽可能大的元素的值 min 和索引 r
                for (int j = len - 1; j > index - i; j--) {
                    if (nums[j] > nums[index - i]) {
                        if (min > nums[j]) {
                            min = nums[j];
                            r = j;
                        }
                    }
                }
                // 执行交换
                int t = nums[index - i];
                nums[index - i] = nums[r];
                nums[r] = t;
                // 对后序序列递增排序
                Arrays.sort(nums, index - i + 1, nums.length);
                return;
            } else
                // 记录后序数列的最大值，避免不必要的查找
                max = nums[index - i];
        }
        Arrays.sort(nums);
    }
}