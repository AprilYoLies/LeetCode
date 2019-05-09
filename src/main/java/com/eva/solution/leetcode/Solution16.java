package com.eva.solution.leetcode;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int adjust = 0;
        for (int s = 0; s < Integer.MAX_VALUE; s++) {
            for (int s1 = 0; s1 < 2; s1++) {
                if (s1 % 2 == 0)
                    adjust = target + s;
                else
                    adjust = target - s;
                for (int i = 0; i < nums.length - 2; ) {
                    for (int j = i + 1; j < nums.length - 1; ) {
                        int k = Arrays.binarySearch(nums, j + 1, nums.length, adjust - (nums[i] + nums[j]));
                        if (k < 0) ;
                        else {
                            return nums[i] + nums[j] + nums[k];
                        }
                        while (++j < nums.length - 1 && nums[j] == nums[j - 1]) ;
                    }
                    while (++i < nums.length - 2 && nums[i] == nums[i - 1]) ;
                }
            }
        }
        return 0;
    }
}
