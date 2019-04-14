package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-04-14
 * @Email g863821569@gmail.com
 */

import java.util.Arrays;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len == 0)
            return 0;
        int from = (len - 1) / 2;
        int[] all = new int[len];

        for (int i = 0; i < nums1.length; i++) {
            all[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            all[i + nums1.length] = nums2[i];
        }

        Arrays.sort(all);

        if ((len + 1) % 2 == 0) {
            return all[from];
        } else
            return (all[from] + all[from + 1]) / 2.0;
    }
}