package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2023-03-18 00:49:55
 * @Email g863821569@gmail.com
 */
public class Solution704 {
    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j - 1) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                j = mid;
            } else {
                i = mid;
            }
        }
        if (nums[i] == target) {
            return i;
        }
        if (nums[j] == target) {
            return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Solution704.search(nums, 7));
    }
}
