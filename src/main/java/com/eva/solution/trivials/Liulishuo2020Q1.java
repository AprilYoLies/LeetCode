package com.eva.solution.trivials;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-11
 * @Email g863821569@gmail.com
 */
public class Liulishuo2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int an = sc.nextInt();
        int bn = sc.nextInt();
        int[][] costs = new int[p][2];
        for (int i = 0; i < p; i++) {
            costs[i][0] = sc.nextInt();
            costs[i][1] = sc.nextInt();
        }
        Arrays.sort(costs, (o1, o2) -> {
            int diff1 = Math.abs(o1[0] - o1[1]);
            int diff2 = Math.abs(o2[0] - o2[1]);
            return -(diff1 - diff2);
        });
        int count = 0;
        for (int[] cost : costs) {
            if (cost[0] > cost[1]) {
                if (bn > 0) {
                    bn--;
                    count += cost[1];
                } else {
                    an--;
                    count += cost[0];
                }
            } else {
                if (an > 0) {
                    an--;
                    count += cost[0];
                } else {
                    bn--;
                    count += cost[1];
                }
            }
        }
        System.out.println(count);
    }
}
