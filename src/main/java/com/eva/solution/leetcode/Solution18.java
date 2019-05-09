package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
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
