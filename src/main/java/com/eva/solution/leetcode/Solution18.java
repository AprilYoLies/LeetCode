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
public class Solution18 {

    @Test
    public void testFourSum() {
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                long sumIJ = nums[i] + nums[j];
                while (l < r) {
                    if (sumIJ + nums[l] + nums[r] == target) {
                        List<Integer> item = new ArrayList<>(4);
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        result.add(item);
                        int cur = nums[l];
                        while (l < r && nums[l] == cur) {
                            l++;
                        }
                        continue;
                    }
                    if (sumIJ + nums[l] + nums[r] > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int s = 0; s < nums.length - 3; ) {
            for (int i = s + 1; i < nums.length - 2; ) {
                for (int j = i + 1; j < nums.length - 1; ) {
                    int k = Arrays.binarySearch(nums, j + 1, nums.length, target - (nums[s] + nums[i] + nums[j]));
                    if (k < 0) ;
                    else {
                        list.add(Arrays.asList(nums[s], nums[i], nums[j], nums[k]));
                    }
                    while (++j < nums.length - 1 && nums[j] == nums[j - 1]) ;
                }
                while (++i < nums.length - 2 && nums[i] == nums[i - 1]) ;
            }
            while (++s < nums.length - 3 && nums[s] == nums[s - 1]) ;
        }
        return list;
    }
}
