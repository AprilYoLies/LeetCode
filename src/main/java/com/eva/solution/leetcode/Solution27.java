package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution27 {
    public static int removeElement(int[] nums, int val) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Solution27.removeElement(nums, 2));
    }

    public int removeElement1(int[] nums, int val) {
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
