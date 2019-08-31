package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * 8
 * 35,92,98,68,35,65,26,72
 * 29,78,83,16,5,89,92,28
 * 48,51,37,79,65,74,50,71
 * 98,78,99,57,1,30,22,16
 * 72,88,55,33,56,58,28,49
 * 4,28,29,20,18,61,11,73
 * 61,19,47,34,85,32,77,89
 * 29,49,10,81,52,5,63,25
 * <p>
 * 76
 * <p>
 * 6
 * 1,2,3,5,7,6
 * 2,1,4,5,7,4
 * 3,4,5,6,3,6
 * 2,3,1,4,6,8
 * 5,6,1,4,6,2
 * 4,2,4,1,1,6
 * <p>
 * 6
 */
public class Ali2020Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n, area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        int[][] dp = new int[n][n];
        if (n <= 1) return 0;
        int min = 1000000;
        if (n == 2) {
            for (int i = 0; i < n; i++) {
                if (area[1][i] < min) min = area[1][i];
            }
            return min;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < 2 || j < 2) {
                    if (i == 0)
                        dp[i][j] = 0;
                    else if (i == 1) {
                        dp[i][j] = 1000000;
                    } else {
                        dp[i][j] = dp[i - 2][j] + area[i - 1][j];
                    }
                    continue;
                }
                dp[i][j] = Math.min((dp[i - 2][j] + area[i - 1][j]), (dp[i][j - 2] + area[i][j - 1]));
            }
        }
        for (int i = 0; i < n; i++) {
            if (min > dp[n - 1][i]) min = dp[n - 1][i];
            if (min > (dp[n - 2][i] + area[n - 1][i])) min = dp[n - 2][i] + area[n - 1][i];
        }
        return min;
    }
}