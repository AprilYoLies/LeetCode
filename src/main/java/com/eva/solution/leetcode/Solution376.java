package com.eva.solution.leetcode;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-08-15
 * @Email g863821569@gmail.com
 */

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution376 {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        if (nums.length == 2 && nums[0] == nums[1])
            return 1;
        int[] len = new int[nums.length];
        Arrays.fill(len, 1);
        int[] isPositive = new int[nums.length];
        len[0] = 1;
        len[1] = 2;
        isPositive[0] = 0;
        isPositive[1] = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    if (nums[i] - nums[0] > 0) {
                        isPositive[i] = 1;
                        len[i] = 2;
                    } else if (nums[i] - nums[0] < 0) {
                        isPositive[i] = -1;
                        len[i] = 2;
                    }
                } else if (isPositive[j] > 0 && nums[i] - nums[j] < 0) {
                    if (len[i] < len[j] + 1) {
                        isPositive[i] = -1;
                        len[i] = len[j] + 1;
                    }
                } else if (isPositive[j] < 0 && nums[i] - nums[j] > 0) {
                    if (len[i] < len[j] + 1) {
                        isPositive[i] = 1;
                        len[i] = len[j] + 1;
                    }
                }
            }
        }
        return len[nums.length - 1];
    }

    public static int wiggleMaxLengthFast(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int a = 1, b = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                a = b + 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                b = a + 1;
            }
        }
        return Math.max(a,b);
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLengthFast(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
