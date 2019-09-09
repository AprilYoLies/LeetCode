package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */
public class ByteDance2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        int idx = -1;
        int max = 0;
        loop:
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                if (heights[j] <= heights[i]) {
                    if (heights[j] > pre) {
                        count++;
                        pre = heights[j];
                    }
                } else {
                    if (count > max) {
                        max = count;
                        idx = i;
                    }
                    continue loop;
                }
            }
            if (count > max) {
                max = count;
                idx = i;
            }
        }
        if (idx == -1) System.out.println(0);
        else System.out.println(heights[idx]);
    }
}
