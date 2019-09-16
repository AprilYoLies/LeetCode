package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-16
 * @Email g863821569@gmail.com
 */

/**
 * 6 5
 * 5 1 1 1 2 3
 */
public class Yuanfudao2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] times = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
            if (i == 0) sum[i] = times[i];
            else sum[i] = sum[i - 1] + times[i];
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (times[i] <= m) dp[i] = 1;
                else dp[i] = 0;
            } else {
                if (sum[i] - sum[i - dp[i - 1]] > m) dp[i] = dp[i - 1];
                else {
                    for (int j = dp[i - 1]; ; j++) {
                        int s = i - j;
                        if (s < 0) {
                            if (sum[i] <= m && i + 1 > dp[i - 1]) dp[i] = i + 1;
                            else if (dp[i] < dp[i - 1]) dp[i] = dp[i - 1];
                            break;
                        } else {
                            if (sum[i] - sum[s] <= m) {
                                dp[i] = j;
                                continue;
                            }
                            dp[i] = j;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
