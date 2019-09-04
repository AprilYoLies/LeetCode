package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-14
 * @Email g863821569@gmail.com
 */

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
    public static int lengthOfLIS1(int[] nums) {
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
        if (nums.length <= 1)
            return nums.length;
        int[] eles = new int[nums.length];
        int pos;
        int max = 0;
        for (int num : nums) {
            pos = findPos(eles, max, num);
            if (pos + 1 > max) {
                max = pos + 1;
            }
        }
        return max;
    }

    private static int findPos(int[] eles, int r, int num) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            if (eles[mid] == num) {
                return mid;
            } else if (eles[mid] < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        eles[l] = num;
        return l;
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        int max = dp[0];
        for (int i : dp) {
            if (i > max) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
