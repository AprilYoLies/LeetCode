package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */

import java.util.Scanner;

// 智慧老人

/**
 * 5
 * 1 5 2 4 6
 * <p>
 * 3
 * 1 1 1
 */
public class ByteDance2020P2Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        System.out.println(calMaxScore(score));
    }

    public static int calMaxScore(int[] scores) {
        int len = scores.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (j < i) continue;
                if (i == j) dp[i][j] = scores[i];
                else {
                    if (i == len - 1) dp[i][j] = scores[i];
                    else dp[i][j] = Math.max(scores[i] - dp[i + 1][j], scores[j] - dp[i][j - 1]);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return (dp[0][len - 1] + sum) / 2;
    }
}
