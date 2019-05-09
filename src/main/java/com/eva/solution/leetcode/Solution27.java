package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int remains = 0;
        for (int i = 0, j = 0; i < nums.length; ) {
            while (nums[i++] == val && i < nums.length) ;
            if (i == nums.length && nums[i - 1] == val)
                break;
            nums[j++] = nums[i - 1];
            remains++;
        }
        return remains;
    }
}
