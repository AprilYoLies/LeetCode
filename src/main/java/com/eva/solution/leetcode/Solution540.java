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
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];
        int l = 1, r = nums.length - 2;
        return binarySearch(nums, l, r);
    }

    /**
     * 二分查找函数
     *
     * @param nums 数组
     * @param l    左边界
     * @param r    右边界
     * @return 目标数
     */
    private static int binarySearch(int[] nums, int l, int r) {
        if (l >= r) {
            if (nums[r] != nums[r - 1] && nums[r] != nums[r + 1])
                return nums[r];
            if (nums[r - 1] != nums[r - 2] && nums[r - 1] != nums[r])
                return nums[r];
            return nums[l];
        }
        int mid = (l + r) >>> 1;    // 中间数的索引
        if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])   // 如果中间数是单个数（就是我们要找的数），直接返回
            return nums[mid];
        int pos = mid;
        if (nums[pos] != nums[pos - 1]) // 这里成立的话，说明 mid 不是成对数的第二个
            pos++;  // 那么就定位到第二个
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
