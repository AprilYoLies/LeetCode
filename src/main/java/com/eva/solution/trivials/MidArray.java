package com.eva.solution.trivials;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-08-19
 * @Email g863821569@gmail.com
 */
public class MidArray {
    public static int[] medianII(int[] nums) {
        // write your code here
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int l = findIndex(nums, i, nums[i]);
            Arrays.sort(nums, l, i + 1);
            res[i] = nums[i / 2];
        }
        return res;
    }

    private static int findIndex(int[] nums, int right, int target) {
        int l = 0, r = right;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        for (int i = r; i < l + 1; i++) {
            if (nums[i] > target)
                return i - 1;
        }
        // Can't be there
        return l;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 3, 2, 6, 0};
        Arrays.sort(arr);
        System.out.println(findIndex(arr, arr.length, 2));
        medianII(arr);
    }
}
