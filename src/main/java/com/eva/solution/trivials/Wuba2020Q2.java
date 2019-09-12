package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-12
 * @Email g863821569@gmail.com
 */
public class Wuba2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = scores[0] > scores[1] ? 2 : 1;
        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[i - 1]) dp[i] = dp[i - 1] + 1;
            else {
                if (dp[i - 1] > 1) dp[i] = 1;
                else {
                    dp[i] = 1;
                    int pre = dp[i];
                    int j = i - 1;
                    while (j >= 0 && dp[j] == pre) {
                        pre = ++dp[j];
                        j--;
                    }
                }
            }
        }
        int sum = 0;
        for (int i : dp) {
            sum += i;
        }
        System.out.println(sum);
    }
}
