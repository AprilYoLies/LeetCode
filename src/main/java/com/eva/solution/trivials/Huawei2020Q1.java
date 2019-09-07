package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-07
 * @Email g863821569@gmail.com
 */

// 7 5 9 4 2 6 8 3 5 4 3 9
public class Huawei2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        int[] steps = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            steps[i] = Integer.parseInt(strs[i]);
        }
        int len = steps.length;
        int[] dp = new int[len];
        for (int i = len - 1; i > 0; i--) {
            if (i == len - 1) dp[i] = 0;
            else {
                if (i + steps[i] > len - 1) dp[i] = -1;
                else {
                    if (dp[i + steps[i]] == -1) dp[i] = -1;
                    else dp[i] = dp[i + steps[i]] + 1;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < len / 2; i++) {
            if (min > dp[i] && dp[i] != -1) min = dp[i];
        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min + 1);
    }
}
