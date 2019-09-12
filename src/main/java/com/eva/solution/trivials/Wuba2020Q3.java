package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-12
 * @Email g863821569@gmail.com
 */
public class Wuba2020Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) dp[i][j] = map[i][j];
                    else if (i == 0) dp[i][j] = dp[i][j - 1] + map[i][j];
                    else dp[i][j] = dp[i - 1][j] + map[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
                }
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
