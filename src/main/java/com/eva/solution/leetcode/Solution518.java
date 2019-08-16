package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-16
 * @Email g863821569@gmail.com
 */

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution518 {
    public static int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (coins == null || coins.length == 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;  // 针对 i - coin = 0 的情况
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0)
                    dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static int change1(int amount, int[] coins) {
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
        System.out.println(change1(5, new int[]{1, 2, 5}));
    }
}
