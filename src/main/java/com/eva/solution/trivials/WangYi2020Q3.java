package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-20
 * @Email g863821569@gmail.com
 */
public class WangYi2020Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        double[][] prices = new double[n][2];
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split(",");
            double c = Double.parseDouble(str[0]);
            double p = Double.parseDouble(str[1]);
            prices[i][0] = c;
            prices[i][1] = p;
        }
        double[][] dp = new double[n + 1][max + 1];
        for (int i = 1; i <= n; i++) {
            int w = (int) prices[i - 1][0];
            double v = prices[i - 1][1] * w;
            for (int j = 1; j <= max; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.format("%1.4f", dp[n][max]);
    }
}
