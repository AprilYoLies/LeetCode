package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-14
 * @Email g863821569@gmail.com
 */

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int[] len = new int[nums.length];
        len[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, len[j] + 1);
                }
            }
            len[i] = max;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len[i] > max)
                max = len[i];
        }
        return max;
    }

    public static int lengthOfLISFast(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = findPos(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private static int findPos(int[] eles, int r, int num) {
        int l = 0, h = r;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (eles[mid] == num) {
                return mid;
            } else if (eles[mid] > num) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLISFast(new int[]{2, 15, 3, 7, 8, 6, 18}));
    }
}
