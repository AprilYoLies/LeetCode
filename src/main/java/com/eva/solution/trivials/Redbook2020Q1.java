package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-03
 * @Email g863821569@gmail.com
 */
public class Redbook2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int blocks = sc.nextInt();
        int max = rows * cols;
        int[][] maps = new int[rows][cols];
        for (int i = 0; i < blocks; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            maps[r][c] = 1;
        }
        int len = calDistance(maps);
        System.out.println(len);
    }

    public static int calDistance(int[][] maps) {
        int rows = maps.length, cols = maps[0].length, max = rows * cols;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) {
                        if (maps[i][j] == 1)
                            return 0;
                        dp[i][j] = maps[i][j];
                    } else {
                        if (maps[i][j] == 1) {
                            dp[i][j] = max;
                        } else {
                            if (i == 0) {
                                dp[i][j] = dp[i][j - 1] + 1;
                            } else {
                                dp[i][j] = dp[i - 1][j] + 1;
                            }
                        }
                    }
                    continue;
                }
                if (maps[i][j] == 1) dp[i][j] = max;
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[rows - 1][cols - 1] > max ? 0 : dp[rows - 1][cols - 1];
    }
}
