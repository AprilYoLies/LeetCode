package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */

/**
 * 3
 * 1 3
 * 2 3
 * 3 3
 * <p>
 * 3
 * 1 1
 * 2 1
 * 3 1
 */
public class ByteDance2020P2Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arrs = new int[n][2];
        for (int i = 0; i < n; i++) {
            arrs[i][0] = sc.nextInt();
            arrs[i][1] = sc.nextInt();
        }
        int queue = 0, time, max = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                queue += arrs[i][1];
                max = queue;
            } else {
                queue -= arrs[i][0] - arrs[i - 1][0];
                if (queue < 0) queue = 0;
                queue += arrs[i][1];
                if (queue > max) max = queue;
            }
        }
        time = arrs[n - 1][0] + queue;
        System.out.println(time + " " + max);
    }
}
