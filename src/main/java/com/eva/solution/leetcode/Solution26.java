package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int remains = 0;
        for (int i = 0, j = 0; i < nums.length; ) {
            remains++;
            nums[j++] = nums[i];
            while (++i < nums.length && nums[i] == nums[i - 1]) ;
        }
        return remains;
    }
}
