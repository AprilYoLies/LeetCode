package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-13
 * @Email g863821569@gmail.com
 */

/**
 * 5 5
 * 01000
 * 11100
 * 11101
 * 11111
 * 00101
 */
public class TuSen2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mn = sc.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (map[i][j] == 1 && map[i - 1][j] == 1 && map[i + 1][j] == 1 &&
                        map[i][j - 1] == 1 && map[i][j + 1] == 1) count++;
            }
        }
        System.out.println(count);
    }
}
