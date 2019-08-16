package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-16
 * @Email g863821569@gmail.com
 */

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution494 {
    // sum(P) - sum(N) = target
    // sum(P) - (sum(All) - sum(P)) = target
    // sum(P) = (target + sum(All)) / 2
//    public static int findTargetSumWays1(int[] nums, int S) {
//        int sumAll = 0;
//        for (int num : nums) {
//            sumAll += num;
//        }
//        if (sumAll < S || (S + sumAll) % 2 == 1)
//            return 0;
//        int target = (S + sumAll) / 2;
//        int[][] dp = new int[nums.length + 1][target + 1];
//        for (int j = 1; j < target + 1; j++) {
//            dp[0][j] = 1;
//        }
//        for (int j = 1; j < nums.length + 1; j++) {
//            dp[j][0] = 1;
//        }
//        for (int i = 1; i < nums.length + 1; i++) {
//            for (int j = 1; j < target + 1; j++) {
//                if (j >= nums[i - 1])
//                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//        return dp[nums.length][target];
//    }

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = W; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[W];
    }

    private static int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
