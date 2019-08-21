package com.eva.solution.trivials;

import java.util.Scanner;

public class MeiTuan2019Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        // dp[i][j] i 表示前 i 件商品，j 为超过金额 j，dp[i][j] 为前 i 件商品超过价值 j 的最小金额
        int[][] dp = new int[n + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            dp[0][j] = 2 * k;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - prices[i - 1] >= 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - prices[i - 1]] + prices[i - 1]);
                else
                    dp[i][j] = Math.min(dp[i - 1][j], prices[i - 1]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
