package com.eva.solution.leetcode;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-08-17
 * @Email g863821569@gmail.com
 */
public class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        if (nums[0] == nums[nums.length - 1]) {
            if (nums[0] == target) {
                res[0] = 0;
                res[1] = nums.length - 1;
            }
            return res;
        }
        int l = 1, r = nums.length - 1;
        if (!(nums[0] == target)) {
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (isLessThan(nums[mid], target)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            for (int i = r; i < nums.length; i++) {
                if (isEquals(nums[i], target)) {
                    res[0] = i;
                    break;
                } else if (isGreaterThan(nums[i], target)) {
                    break;
                }
            }
        } else
            res[0] = 0;

        if (nums[nums.length - 1] == target) {
            res[1] = nums.length - 1;
        } else {
            l = 1;
            r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (isGreaterThan(nums[mid], target)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            for (int i = r; i < nums.length; i++) {
                if (isGreaterThan(nums[i], target)) {
                    if (isEquals(nums[i - 1], target))
                        res[1] = i - 1;
                    else break;
                }
            }
            // Can't run to there
        }
        return res;
    }

    public static boolean isLessThan(int cur, int target) {
        return cur < target;
    }

    public static boolean isGreaterThan(int cur, int target) {
        return cur > target;
    }

    public static boolean isEquals(int cur, int target) {
        return cur == target;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{}, 8)));
    }
}
