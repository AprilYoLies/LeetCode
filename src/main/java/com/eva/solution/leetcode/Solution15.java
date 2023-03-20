package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution15 {
    @Test
    public void testThreeSum() {
        int[] nums = new int[]{0, 0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sumIJ = nums[i] + nums[j];
                while (k > j && sumIJ + nums[k] > 0) {
                    k--;
                }
                if (k > j && sumIJ + nums[k] == 0) {
                    List<Integer> item = new ArrayList<>(3);
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[k]);
                    result.add(item);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {
            for (int j = i + 1; j < nums.length - 1; ) {
                int k = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
                if (k < 0) ;
                else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                while (++j < nums.length - 1 && nums[j] == nums[j - 1]) ;
            }
            while (++i < nums.length - 2 && nums[i] == nums[i - 1]) ;
        }
        return list;
    }
}
