package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-17
 * @Email g863821569@gmail.com
 */
public class Solution540 {
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int l = 0, r = nums.length - 1;
        return binarySearch(nums, l, r);
    }

    private static int binarySearch(int[] nums, int l, int r) {
        if (l >= r) {
            if (r == 0) return nums[0];
            if (r == nums.length - 1) return nums[nums.length - 1];
            if (nums[r] != nums[r - 1] && nums[r] != nums[r + 1])
                return nums[r];
            if (nums[r - 1] != nums[r - 2] && nums[r - 1] != nums[r])
                return nums[r];
            return nums[l];
        }
        int mid = (l + r) >>> 1;
        if (mid == 0) return nums[0];
        if (mid == nums.length - 1) return nums[nums.length - 1];
        if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
            return nums[mid];
        int pos = mid;
        if (nums[pos] != nums[pos - 1])
            pos++;
        if ((pos & 1) != 0) {   // 奇数 查找右边
            return binarySearch(nums, mid + 1, r);
        } else {    // 偶数 查找左边
            return binarySearch(nums, l, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));
    }
}
