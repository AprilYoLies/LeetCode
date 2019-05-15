package com.eva.solution.leetcode;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-05-14
 * @Email g863821569@gmail.com
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int len = nums.length - 1, res;
        // 这种情况下，整个数组序列就是按照从小到大的顺序排列
        if (nums[0] < nums[len]) return Arrays.binarySearch(nums, target) < 0 ? -1 : Arrays.binarySearch(nums, target);
        int l = 0, r = len, mid = (l + r) / 2;
        // 找到旋转切点，比如原数组是 [5, 6, 7, 9, 10, 1, 2, 4],则旋转切点为 l = 4，r = 5
        while (l + 1 < r) {
            if (nums[mid] > nums[r]) {
                l = mid;
            } else {
                r = mid;
            }
            mid = (l + r) / 2;
        }
        // 确定 target 是在旋转切点之前还是之后
        if (target > nums[len]) res = Arrays.binarySearch(nums, 0, l + 1, target);
        else res = Arrays.binarySearch(nums, r, len + 1, target);
        if (res >= 0) return res;
        return -1;
    }
}
