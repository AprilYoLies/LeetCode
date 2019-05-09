package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
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
